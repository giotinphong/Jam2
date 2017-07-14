package com.swings.jam.data;

import java.util.ArrayList;

/**
 * Created by sonnguyen on 6/28/17.
 */

public class DataNote {
    private Node<String> node;
    public DataNote() {
        node = new Node<String>("DB");
        setup();
    }

    public void setup(){
        //node.addChild("Type");
        int dem = 1;
        Type type = new Type(dem++,"jazz",0);
        ArrayList<Type> typeArrayList = new ArrayList<>();
            typeArrayList.add(new Type(dem++,"JAZZ",0));
        typeArrayList.add(new Type(dem++,"ROCK",0));
        typeArrayList.add(new Type(dem++,"BALLAD",0));
        typeArrayList.add(new Type(dem++,"BLUE",0));
        typeArrayList.add(new Type(dem++,"POP",0));
        typeArrayList.add(new Type(dem++,"RnB",0));
        typeArrayList.add(new Type(dem++,"Other",0));
        for(Type type1 : typeArrayList)
        node.child("Type").child(type1.getId()).setData(type1);

         node.child("Type").getChildren();
        node.child("Type").child(2).getData();

    }
}
