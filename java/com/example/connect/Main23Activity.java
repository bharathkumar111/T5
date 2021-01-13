package com.example.connect;





import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;


public class Main23Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("dhoni", R.drawable.dhoni),
                new MyListData("ambati rayudu", R.drawable.ambati),
                new MyListData("deepak chahar", R.drawable.depak),
                new MyListData("faf", R.drawable.faf),
                new MyListData("harbhajan", R.drawable.harbhajan
                ),
                new MyListData("jadeja", R.drawable.jadeja),
                new MyListData("kedhar", R.drawable.kedhar),
                new MyListData("raina",R.drawable.raina),
                new MyListData("shardul thakur", R.drawable.shardul),
                new MyListData("Imran tahir", R.drawable.tahir),
                new MyListData("watson", R.drawable.watson)
                , new MyListData("sam curran", R.drawable.sam)
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

