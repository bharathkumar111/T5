package com.example.connect;













import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;


public class Main28Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Kane williamson", R.drawable.kane),
                new MyListData("jonny bairstow", R.drawable.bairstow),
                new MyListData("manish pandey", R.drawable.manish),
                new MyListData("rasheed khan", R.drawable.rasheed),
                new MyListData("mohammad nabi", R.drawable.nabi
                ),
                new MyListData("vijay shankar", R.drawable.vijay),
                new MyListData("khaleel ", R.drawable.khaleel),
                new MyListData("david warner",R.drawable.david),
                new MyListData("siddarth kaul",R.drawable.kaul),
                new MyListData("bhuvaneshwar kumar",R.drawable.bhuvi),








        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter2 adapter = new MyListAdapter2(myListData);


        String bk="virat kohli";


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}




