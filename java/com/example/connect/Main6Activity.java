package com.example.connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
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

public class Main6Activity extends AppCompatActivity {
    ListView listViewArtists;
    DatabaseReference databaseArtists;
    List<Artist> artistList;
    ImageView imageView;
    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private  DatabaseReference databaseReference=firebaseDatabase.getReference();
    private DatabaseReference first=databaseReference.child("image2");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        imageView=findViewById(R.id.imageView6);

        MediaController mediaController=new MediaController(this);

        VideoView videoView = findViewById(R.id.videoView2);

        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        Uri uri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/connect-cef13.appspot.com/o/rohith2.mp4?alt=media&token=7193c03e-6e3d-4511-b356-3fb9475c88bb");
        videoView.setVideoURI(uri);
        videoView.start();
        listViewArtists = findViewById(R.id.listview2);
        databaseArtists = FirebaseDatabase.getInstance().getReference("rohith");
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
                ArtistList adapter = new ArtistList(Main6Activity.this, artistList);
                listViewArtists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
