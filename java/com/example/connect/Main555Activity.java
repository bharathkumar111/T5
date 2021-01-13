package com.example.connect;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main555Activity extends AppCompatActivity {
   EditText e1,e2;
    Button b,b2;
ListView listViewArtists;
DatabaseReference databaseArtists;
List<Artist> artistList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main555);
        listViewArtists=findViewById(R.id.listViewArtists);
        databaseArtists= FirebaseDatabase.getInstance().getReference("newdetails2");
        artistList=new ArrayList<>();
       e1=findViewById(R.id.editText8);
       e2=findViewById(R.id.editText9);
        b=findViewById(R.id.button19);

        b2=findViewById(R.id.button20);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
        }

    });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                databaseArtists.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange( DataSnapshot dataSnapshot) {
                        artistList.clear();
                        for(DataSnapshot artistSnapshot : dataSnapshot.getChildren()){
                            Artist artist=artistSnapshot.getValue(Artist.class);

                            artistList.add(artist);
                        }
                        ArtistList adapter=new ArtistList(Main555Activity.this,artistList);
                        listViewArtists.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled( DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private void addArtist(){
        String name=e1.getText().toString();
        String genre=e2.getText().toString();
        if(!TextUtils.isEmpty(name))
        {
       String id=    databaseArtists.push().getKey();
       Artist artist=new Artist(id,name,genre);
       databaseArtists.child(id).setValue(artist);
       Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(Main555Activity.this, "enter name", Toast.LENGTH_SHORT).show();
        }
    }


    }

