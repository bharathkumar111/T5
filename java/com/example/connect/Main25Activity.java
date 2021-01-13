package com.example.connect;









import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Main25Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Shreyas iyer", R.drawable.shreyasi),
                new MyListData("shikhar dhavan", R.drawable.dhavan),
                new MyListData("ishant sharma", R.drawable.ishant),
                new MyListData("axar patel", R.drawable.akshar),
                new MyListData("rishabh panr", R.drawable.pant
                ),
                new MyListData("jason roy", R.drawable.roy),
                new MyListData("kagiso rabada", R.drawable.kagiso),
                new MyListData("amith mishra",R.drawable.amit),
                new MyListData("sandeep", R.drawable.sandeep),
                new MyListData("prithvi shaw", R.drawable.parthiv),
                new MyListData("Alex Carey", R.drawable.alex),
                new MyListData("Chris woakes", R.drawable.chris),





        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter2 adapter = new MyListAdapter2(myListData);


        String bk="virat kohli";


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem item=menu.findItem(R.id.a1);

        SearchView searchView= (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {




                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}



