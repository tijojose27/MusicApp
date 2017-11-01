package com.tijojose27.musicapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by tijojose27 on 10/24/2017.
 */

public class SongAdapter extends ArrayAdapter<Music>{


    public static final String KEY_SONG = "this_song";

    private TextView songTextView;
    private TextView albumTextView;
    private TextView artistTextView;
    private ImageView imageImageView;
    private Button playButton;

    public SongAdapter(@NonNull Context context, ArrayList<Music> mMusic) {
        super(context, 0, mMusic);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(convertView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
            //SETTING ALL THE TEXT VIEWS AND THE IMAGEVIEWS
            songTextView = (TextView) listItemView.findViewById(R.id.songItem_song_Text_View);
            albumTextView = (TextView) listItemView.findViewById(R.id.songItem_album_Text_View);
            artistTextView = (TextView) listItemView.findViewById(R.id.songItem_artist_Text_View);
            imageImageView = (ImageView) listItemView.findViewById(R.id.songItem_image_Image_View);
            playButton = (Button) listItemView.findViewById(R.id.songPlay_song_item_Button);
        }

        //GETTING THE CURRENT MUSIC OBJECT
        final Music currentMusic = getItem(position);

        songTextView.setText(currentMusic.getSongName());
        albumTextView.setText(currentMusic.getAlbumName());
        artistTextView.setText(currentMusic.getArtistName());
        imageImageView.setImageResource(currentMusic.getImageResource());


        //CREATING GENERIC CLICK LISTENER AND SENDING THE CURRENT MUSIC OBJECT
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playSongIntent = new Intent(getContext(), PlaySongActivity.class);
                playSongIntent.putExtra(KEY_SONG, currentMusic);
                getContext().startActivity(playSongIntent);
            }
        };
        //SETTING BUTTONS FOR THE CLICK LISTNER
        imageImageView.setOnClickListener(onClick);
        albumTextView.setOnClickListener(onClick);
        artistTextView.setOnClickListener(onClick);
        songTextView.setOnClickListener(onClick);
        playButton.setOnClickListener(onClick);

        return listItemView;
    }


}
