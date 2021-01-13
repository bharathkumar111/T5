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


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Virat kohli", R.drawable.virat3),
                new MyListData("Rohith sharma", R.drawable.rohith),
                new MyListData("dhoni", R.drawable.dhoni),
                new MyListData("kl rahul", R.drawable.kl1),
                new MyListData("shikhar dhavan", R.drawable.dhavan

                ),
                new MyListData("hardik", R.drawable.hardik),
                new MyListData("bumra", R.drawable.bumra),
                new MyListData("krunal pandya",R.drawable.krunal),
                new MyListData("kuldeep yadav", R.drawable.kuldeep),
                new MyListData("bhuvaneshwar kumar", R.drawable.bhuvi),
                new MyListData("manish pandey", R.drawable.manish),
                new MyListData("rishabh pant", R.drawable.pant),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter adapter = new MyListAdapter(myListData);


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

