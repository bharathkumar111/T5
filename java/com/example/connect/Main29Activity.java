package com.example.connect;














import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



import android.os.Bundle;


public class Main29Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("KL Rahul", R.drawable.kl1),
                new MyListData("mayank agarwal", R.drawable.mayank),
                new MyListData("mandeep singh", R.drawable.mandeep),
                new MyListData("mujeeb ur rahman", R.drawable.mujjeeb),
                new MyListData("nicholas pooran", R.drawable.pooran
                ),
                new MyListData("sarfaraz khan", R.drawable.sarfaraz),
                new MyListData("sheldon cottrell", R.drawable.cottrel),
                new MyListData("Maxwel", R.drawable.maxwel),
                new MyListData("Chris gayle", R.drawable.gayle),
                new MyListData("shami", R.drawable.shami),








        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card);

        MyListAdapter2 adapter = new MyListAdapter2(myListData);


        String bk="virat kohli";


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}




