package com.example.connect;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;


public class Main22Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Virat kohli", R.drawable.virat3),
                new MyListData("chahal", R.drawable.chahal),
                new MyListData("abd villers", R.drawable.abd),
                new MyListData("gurukeerat singh", R.drawable.gurukeerat),
                new MyListData("aron finch", R.drawable.finch
                ),
                new MyListData("kane richardson", R.drawable.kane),
                new MyListData("chris morris", R.drawable.morris),
                new MyListData("devadatt padikal",R.drawable.padikkal),
                new MyListData("navdeep saini", R.drawable.navdeep),
                new MyListData("Dale stein", R.drawable.stein),
                new MyListData("umesh", R.drawable.umesh)
               ,
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter2 adapter = new MyListAdapter2(myListData);


        String bk="virat kohli";


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

