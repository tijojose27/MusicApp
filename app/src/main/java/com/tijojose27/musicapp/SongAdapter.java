package com.tijojose27.musicapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by tijojose27 on 10/24/2017.
 */

public class SongAdapter extends ArrayAdapter<Music>{

    private TextView songTextView;
    private TextView albumTextView;
    private TextView artistTextView;
    private ImageView imageImageView;

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
        }

        //GETTING THE CURRENT MUSIC OBJECT
        final Music currentMusic = getItem(position);

        songTextView.setText(currentMusic.getmSongName());
        albumTextView.setText(currentMusic.getmAlbumName());
        artistTextView.setText(currentMusic.getmArtistName());
        imageImageView.setImageResource(currentMusic.getmImageResource());


        //CREATING GENERIC CLICK LISTENER AND SENDING THE CURRENT MUSIC OBJECT
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playSongIntent = new Intent(getContext(), PlaySongActivity.class);
                playSongIntent.putExtra("this song", currentMusic);
                getContext().startActivity(playSongIntent);
            }
        };
        //SETTING BUTTONS FOR THE CLICK LISTNER
        imageImageView.setOnClickListener(onClick);
        albumTextView.setOnClickListener(onClick);
        artistTextView.setOnClickListener(onClick);
        songTextView.setOnClickListener(onClick);

        return listItemView;
    }


}
