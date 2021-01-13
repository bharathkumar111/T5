package com.example.connect;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main17Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        VideoView videoView=findViewById(R.id.videoView2);
        String videopath="android.resource://"+getPackageName()+"/"+R.raw.rishabh2;
        Uri uri= Uri.parse(videopath);
        videoView.setVideoURI(uri);


        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
