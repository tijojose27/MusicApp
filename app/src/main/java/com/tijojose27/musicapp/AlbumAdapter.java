package com.tijojose27.musicapp;

import android.content.Context;
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
 * Created by tijojose27 on 10/31/2017.
 */

public class AlbumAdapter extends ArrayAdapter<Music>{
    public AlbumAdapter(@NonNull Context context, ArrayList<Music> mMusic) {
        super(context, 0, mMusic);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(convertView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.albums_item, parent, false);
        }

        Music currentMusic = getItem(position);

        TextView songTextView = (TextView) listView.findViewById(R.id.albumItem_song_Text_View);
        TextView albumTextView = (TextView) listView.findViewById(R.id.albumItem_album_Text_View);
        TextView artistTextView = (TextView) listView.findViewById(R.id.albumItem_artist_Text_View);
        ImageView imageImageView = (ImageView) listView.findViewById(R.id.albumItem_image_Image_View);

        songTextView.setText(currentMusic.getSongName());
        albumTextView.setText(currentMusic.getAlbumName());
        artistTextView.setText(currentMusic.getArtistName());
        imageImageView.setImageResource(currentMusic.getImageResource());

        return listView;
    }
}
