package com.example.connect;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> implements Filterable {
  private MyListData[] listdata;
    List<String> moviesListAll;

    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final MyListData myListData = listdata[position];
        holder.textView.setText(listdata[position].getDescription());
        holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            int bk;

            @Override
            public void onClick(View view) {

                final Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(context,Main5Activity.class);
                        break;
                    case 1:
                        intent =  new Intent(context, Main6Activity.class);
                        break;

                    case 2:
                        intent =  new Intent(context, Main7Activity.class);
                        break;
                    case 3:  intent =  new Intent(context, Main8Activity.class);
                        break;
                    case 4:  intent =  new Intent(context, Main9Activity.class);
                        break;


                    case 5:  intent =  new Intent(context, Main10Activity.class);
                        break;

                    case 6:  intent =  new Intent(context, Main11Activity.class);
                        break;


                    case 7:  intent =  new Intent(context, Main12Activity.class);
                        break;

                    case 8:  intent =  new Intent(context, Main13Activity.class);
                        break;


                    case 9:  intent =  new Intent(context, Main14Activity.class);
                        break;


                    case 10:  intent =  new Intent(context, Main15Activity.class);
                        break;



                    case 11:  intent =  new Intent(context, Main17Activity.class);
                        break;



                    default:
                        intent =  new Intent(context, Main4Activity.class);
                        break;
                }
                context.startActivity(intent);




            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }


    private  Context context = null;

    @Override
    public Filter getFilter() {

        return filter;
    }
    Filter filter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredList=new ArrayList<>();
            if ( charSequence.toString().isEmpty()){
                filteredList.addAll(moviesListAll);
            }
            else
            {
                for(String movie: moviesListAll)
                {
                    if(movie.toLowerCase().contains(charSequence.toString().toLowerCase()))
                    {
                        filteredList.add(movie);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            notifyDataSetChanged();

        }
    };


    public  class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
           context=itemView.getContext();
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }


}
