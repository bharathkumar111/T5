package com.example.connect;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


public class MyListAdapter2 extends RecyclerView.Adapter<MyListAdapter2.ViewHolder> {
    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter2(MyListData[] listdata) {
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

