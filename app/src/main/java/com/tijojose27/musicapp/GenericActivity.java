package com.tijojose27.musicapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by tijojose27 on 10/31/2017.
 */

public class GenericActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        //GETTING THE ARRAYLIST OF MUSIC FROM THE PARENT ACTIVITY
        ArrayList<Music> musics = getIntent().getParcelableArrayListExtra("stuff");

        //SETTING A LISTVIEW
        ListView listView = (ListView) findViewById(R.id.music_List_View);

        //INTIALIZING A NULL ADAPTER
        String adapterName = null;

        //GETTING THE TYPE OF ADAPTER THAT SHOULD BE CALLED
        //DID THIS USING A PUT EXTRA DIDNT KNOW ANYOTHER WAY

        Bundle extras = getIntent().getExtras();
        adapterName = extras.getString("Adapter");

        //USING SWITCH STATEMENT TO SET THE CORRCT ADAPTER
        switch (adapterName){
            case "Song":
                SongAdapter Sadapter = new SongAdapter(this, musics);
                listView.setAdapter(Sadapter);
                break;
            case "Artist":
                ArtistAdapter Aadapter = new ArtistAdapter(this, musics);
                listView.setAdapter(Aadapter);
                break;
            default:
                AlbumAdapter Aladapter = new AlbumAdapter(this, musics);
                listView.setAdapter(Aladapter);
                break;
        }
    }
}
