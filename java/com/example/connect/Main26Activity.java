package com.example.connect;











import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;


public class Main26Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Dinesh karthik", R.drawable.dinesh),
                new MyListData("shubman gill", R.drawable.gill),
                new MyListData("eoin morgan", R.drawable.morgan),
                new MyListData("andre russel", R.drawable.russel),
                new MyListData("rinku singh", R.drawable.rinku
                ),
                new MyListData("sunil nariene", R.drawable.narine),
                new MyListData("kuldep yadav", R.drawable.kuldeep),
                new MyListData("lockie ferguson",R.drawable.ferguson),
                new MyListData("Nithish Rana",R.drawable.rana),
                new MyListData("rahul tripati",R.drawable.tripati),
                new MyListData("varun chakravarthi",R.drawable.varun),








        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter2 adapter = new MyListAdapter2(myListData);


        String bk="virat kohli";


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}




