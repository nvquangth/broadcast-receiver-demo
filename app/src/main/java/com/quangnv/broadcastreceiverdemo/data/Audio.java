package com.quangnv.broadcastreceiverdemo.data;

import java.io.Serializable;

public class Audio implements Serializable {

    private String mName;
    private String mPath;
    private int mImage;
    private String mAuthor;
    private int mDuration;

    public Audio() {

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }
}
