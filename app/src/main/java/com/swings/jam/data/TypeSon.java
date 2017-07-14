package com.swings.jam.data;

import android.support.annotation.DrawableRes;

/**
 * Created by sonnguyen on 6/28/17.
 */

public class TypeSon {
    private int id,id_type;
    private @DrawableRes int image;
    private String name;

    public TypeSon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(@DrawableRes int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeSon(int id_type, int image, String name) {

        this.id_type = id_type;
        this.image = image;
        this.name = name;
    }
}
