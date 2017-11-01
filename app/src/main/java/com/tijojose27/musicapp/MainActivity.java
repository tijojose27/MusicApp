package com.tijojose27.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Music> musics = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZING ALL THE TEXT VIEWS
        Button albums = (Button) findViewById(R.id.main_Album_view);
        Button artist = (Button) findViewById(R.id.main_Artist_View);
        Button songs = (Button) findViewById(R.id.main_Songs_View);

        //CREATING AN ARRAYLIST OF MUSIC
        musics.add(new Music("Sing along", "Kids", "14 and under", R.mipmap.kids));
        musics.add(new Music("this ballerina", "Ballerina", "Russian ballet", R.mipmap.pop));
        musics.add(new Music("Violin Sad", "Great Violin", "Emptional", R.mipmap.violine));

        //CREATING A GENERIC ONCLICK LISTENER AND PASSING IN THE APPROPRIATE ONLCICK MEHTOD
        View.OnClickListener myOnClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent currIntent=null;

                //USING SWITCH STATEMENT TO GET THE CURRENT BUTTON CLICKED, ASSIGNING INTENT AND SENDING
                //SOME STRING TO GET AN IDEA OF WHAT ADAPTER SHOULD BE CALLED
                switch (v.getId()){

                    case R.id.main_Songs_View:
                        currIntent = new Intent(MainActivity.this, GenericActivity.class);
                        currIntent.putExtra("Adapter", "Song");
                        break;

                    case R.id.main_Album_view:
                        currIntent= new Intent(MainActivity.this, GenericActivity.class);
                        currIntent.putExtra("Adapter", "Album");
                        break;

                    case R.id.main_Artist_View:
                        currIntent= new Intent(MainActivity.this, GenericActivity.class);
                        currIntent.putExtra("Adapter", "Artist");
                        break;

                    default:
                        break;
                }
                //PUTTING IN THE ARRAYLIST USING PARCELABLE
                currIntent.putParcelableArrayListExtra("stuff", musics);

                //STARTING ACTIVITY ASSIGNED BY SWITCH
                startActivity(currIntent);

            }
        };

        //SETTING ONCLICK LISTENER TO BUTTONS
        songs.setOnClickListener(myOnClick);
        artist.setOnClickListener(myOnClick);
        albums.setOnClickListener(myOnClick);
    }
}
