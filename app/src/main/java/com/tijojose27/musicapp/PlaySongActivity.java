package com.tijojose27.musicapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tijojose27 on 10/31/2017.
 */



public class PlaySongActivity extends AppCompatActivity{

    public static final String KEY_SONG = "this_song";

    public MediaPlayer songMedia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_play_item);

        TextView songTV = (TextView) findViewById(R.id.song_song_play_item);
        ImageView songIV = (ImageView) findViewById(R.id.image_song_play_item);
        //GETTING MUSIC FROM SONG ACTIVITY
        Music currMusic = getIntent().getParcelableExtra(KEY_SONG);

        songIV.setImageResource(currMusic.getImageResource());
        songTV.setText(currMusic.getSongName());

        Button playButt = (Button) findViewById(R.id.play_song_play_item);
        Button pauseButt = (Button) findViewById(R.id.pause_song_play_item);

        //CREATING MEDIA PLAYER TO PLAY SONG
        songMedia = MediaPlayer.create(this, R.raw.acousticbreeze);

        //ASSIGNING ONCLICK LISTENER TO PLAY BUTTON
        playButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songMedia.start();
            }
        });

        //ASSIGNING ONCLICK LISTENER TO PAUSE BUTTON
        pauseButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songMedia.pause();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    //METHOD TO RELEASE MEDIA PLAYER WHEN NOT IN USE
    private void releaseMediaPlayer(){
        if(songMedia!=null){
            songMedia.release();
        }
        songMedia=null;
    }
}
