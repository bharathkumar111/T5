
package com.example.connect;





import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main12Activity extends AppCompatActivity {
    ListView listViewArtists;
    DatabaseReference databaseArtists;
    List<Artist> artistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        VideoView videoView = findViewById(R.id.videoView2);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.pandya;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        listViewArtists = findViewById(R.id.listview12);
        databaseArtists = FirebaseDatabase.getInstance().getReference("krunal");
        artistList = new ArrayList<>();


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }

    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artistList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    Artist artist = artistSnapshot.getValue(Artist.class);

                    artistList.add(artist);
                }
                ArtistList adapter = new ArtistList(Main12Activity.this, artistList);
                listViewArtists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}




