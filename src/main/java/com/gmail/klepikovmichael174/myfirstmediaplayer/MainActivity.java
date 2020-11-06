package com.gmail.klepikovmichael174.myfirstmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create a media player, that will be play a music file from raw folder
        mediaPlayer = MediaPlayer.create(this, R.raw.play);
        //create a button to start music file
        Button playButton =(Button) findViewById(R.id.button_play);
        //set on click for pause button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Play", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        //adding Toast to show when song is completed
                        Log.i("Complete Listener", "Song Complete");
                        Toast.makeText(MainActivity.this, "Media Complete", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        //create a button to pause music file
        Button pauseButton =(Button) findViewById(R.id.button_pause);
        //set on click for pause button
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Pause", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });




    }

}