package com.example.myapplication455;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlay extends AppCompatActivity {

    VideoView Video1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_video_play);
        Video1 =(VideoView)findViewById(R.id.video1);
        //Set MediaController  to enable play, pause, forward, etc options.
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(Video1);
        //Location of Media File
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_file);
        //Starting VideView By Setting MediaController and URI
        Video1.setMediaController(mediaController);
        Video1.setVideoURI(uri);
        Video1.requestFocus();
        Video1.start();

    }

    public void play(View view) {


    }
}
