package com.swings.jam.data;


import android.support.annotation.DrawableRes;

import com.swings.jam.R;

/**
 * Created by sonnguyen on 6/28/17.
 */

public class Type {
    private int id;
    private @DrawableRes int image;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type() {

    }

    public Type(int image, String name) {

        this.image = image;
        this.name = name;
    }

    public Type(String name) {
        this.name = name;
        this.image = R.mipmap.ic_launcher;
    }

    public Type(int id, String name, int image) {
        this.id = id;
        this.image = image;
        this.name = name;
    }
}
