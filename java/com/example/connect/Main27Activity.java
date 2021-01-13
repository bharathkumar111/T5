package com.example.connect;













import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;


public class Main27Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Steve smith", R.drawable.smith),
                new MyListData("david miller", R.drawable.miller),
                new MyListData("ben stokes", R.drawable.stokes),
                new MyListData("jaydev unadkat", R.drawable.undkat),
                new MyListData("jos buttler", R.drawable.buttler
                ),
                new MyListData("shreyas gopal", R.drawable.gopal),
                new MyListData("ankit rajpoot", R.drawable.ankith),
                new MyListData("jofra archer",R.drawable.archer),
                new MyListData("Riyan parag",R.drawable.parag),
                new MyListData("Andrew tye",R.drawable.tye),
                new MyListData("Jos Buttler",R.drawable.buttler),
                new MyListData("Sanju Samson",R.drawable.samson),







        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter2 adapter = new MyListAdapter2(myListData);


        String bk="virat kohli";


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}




