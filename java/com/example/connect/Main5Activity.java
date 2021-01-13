package com.example.connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {

    EditText e1, e2;
    ImageView imageView;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private  DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference first=databaseReference.child("image99");

    Button b;
    ListView listViewArtists;
    DatabaseReference databaseArtists;
    List<Artist> artistList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        imageView=findViewById(R.id.imageView45);

MediaController mediaController=new MediaController(this);

        VideoView videoView = findViewById(R.id.videoView2);

       videoView.setMediaController(mediaController);
       mediaController.setAnchorView(videoView);

       Uri uri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/connect-cef13.appspot.com/o/Virat_Kohli_-_World_Number_1__India_Player_Feature__ICC_Cricket_World_Cup_2019(360p).mp4?alt=media&token=c4a99387-f1b7-4dc6-b71e-3a9ac3942cba");
       videoView.setVideoURI(uri);
       videoView.start();
        listViewArtists = findViewById(R.id.listview2);
        databaseArtists = FirebaseDatabase.getInstance().getReference("artists");
        artistList = new ArrayList<>();




    }

    protected void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link=dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artistList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    Artist artist = artistSnapshot.getValue(Artist.class);

                    artistList.add(artist);
                }
                ArtistList adapter = new ArtistList(Main5Activity.this, artistList);
                listViewArtists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
