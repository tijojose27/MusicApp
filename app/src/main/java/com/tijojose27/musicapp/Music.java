package com.tijojose27.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tijojose27 on 10/23/2017.
 */

public class Music implements Parcelable{
    private String mAlbumName;
    private String mArtistName;
    private String mSongName;

    private int mImageResource;




    public Music(String mSongName, String mArtistName, String mAlbumName, int mImageResource) {
        this.mAlbumName = mAlbumName;
        this.mArtistName = mArtistName;
        this.mSongName = mSongName;
        this.mImageResource = mImageResource;
    }

    protected Music(Parcel in) {
        mAlbumName = in.readString();
        mArtistName = in.readString();
        mSongName = in.readString();
        mImageResource = in.readInt();
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

    public String getmAlbumName() {
        return mAlbumName;
    }

    public int getmImageResource() {
        return mImageResource;
    }


    public String getmArtistName() {
        return mArtistName;
    }

    public String getmSongName() {
        return mSongName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mAlbumName);
        dest.writeString(mArtistName);
        dest.writeInt(mImageResource);
    }
}
