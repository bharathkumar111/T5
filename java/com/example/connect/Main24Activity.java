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


public class Main24Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyListData[] myListData = new MyListData[] {
                new MyListData("Rohith sharma", R.drawable.rohith),
                new MyListData("Hardik pandya", R.drawable.hardik),
                new MyListData("jasprit bumra", R.drawable.bumra),
                new MyListData("kieron pollard", R.drawable.pollard),
                new MyListData("suryakumar yadav", R.drawable.surya
                ),
                new MyListData("chris lynn", R.drawable.lynn),
                new MyListData("Ishan kishan", R.drawable.kishan),
                new MyListData("Lasith Malinga",R.drawable.malinga),
                new MyListData("krunal", R.drawable.krunal),
                new MyListData("Trent Boult", R.drawable.boult),
                new MyListData("rahul chahar", R.drawable.rahulchahar
                )

                ,
                new MyListData("Aditya tare", R.drawable.aditya),
                new MyListData("Sherfane rutherford", R.drawable.sherfane),
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


