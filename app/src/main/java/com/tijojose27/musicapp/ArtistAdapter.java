package com.tijojose27.musicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tijojose27 on 10/31/2017.
 */

public class ArtistAdapter extends ArrayAdapter<Music>{

    public ArtistAdapter(@NonNull Context context, @NonNull ArrayList<Music> musics) {
        super(context, 0, musics);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if(convertView==null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.artist_item, parent, false);
        }
        Music currMusic = getItem(position);

        TextView artistTV = (TextView) listView.findViewById(R.id.artist_artist_Text_View);

        artistTV.setText(currMusic.getArtistName());



        return listView;
    }
}
