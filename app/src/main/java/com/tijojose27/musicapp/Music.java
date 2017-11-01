package com.tijojose27.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tijojose27 on 10/23/2017.
 */

public class Music implements Parcelable{
    private String albumName;
    private String artistName;
    private String songName;

    private int imageResource;

    public Music(String songName, String artistName, String AlbumName, int imageResource) {
        this.albumName = AlbumName;
        this.artistName = artistName;
        this.songName = songName;
        this.imageResource = imageResource;
    }

    protected Music(Parcel in) {
        albumName = in.readString();
        artistName = in.readString();
        songName = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    public String getAlbumName() {
        return albumName;
    }

    public int getImageResource() {
        return imageResource;
    }


    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(albumName);
        dest.writeString(artistName);
        dest.writeInt(imageResource);
    }
}
