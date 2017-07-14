package com.swings.jam.data;

import android.net.Uri;

/**
 * Created by sonnguyen on 6/28/17.
 */

public class BackingTrack {
    private String name,composser,tone,chord,linkMp3,linkPurchase,LocationUri;
    private int count,id,tempo,id_typeson;
    private boolean isFavorite;

    public BackingTrack(String name, String composser, String tone, int id_typeson, String linkMp3, int tempo) {
        this.name = name;
        this.composser = composser;
        this.tone = tone;
        this.id_typeson = id_typeson;
        this.linkMp3 = linkMp3;
        this.tempo = tempo;

    }

    public BackingTrack() {

    }

    public void setLinkMp3(String linkMp3) {
        this.linkMp3 = linkMp3;
    }

    public String getLinkPurchase() {
        return linkPurchase;
    }

    public void setLinkPurchase(String linkPurchase) {
        this.linkPurchase = linkPurchase;
    }

    public String getLocationUri() {
        return LocationUri;
    }

    public void setLocationUri(String locationUri) {
        LocationUri = locationUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BackingTrack(String tone, String chord, int id_typeson, String linkMp3,int tempo) {
        this.tone = tone;
        this.linkMp3 = linkMp3;
        this.chord = chord;
        this.id_typeson = id_typeson;
        count = 0;
        isFavorite = false;
        this.tempo = tempo;
    }

    public BackingTrack(String name, String composser, String tone, String chord, int id_typeson, int count, boolean isFavorite,String linkMp3) {
        this.linkMp3 = linkMp3;
        this.name = name;
        this.composser = composser;
        this.tone = tone;
        this.chord = chord;
        this.id_typeson = id_typeson;
        this.count = count;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposser() {
        return composser;
    }

    public void setComposser(String composser) {
        this.composser = composser;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getChord() {
        return chord;
    }

    public void setChord(String chord) {
        this.chord = chord;
    }

    public int getId_typeson() {
        return id_typeson;
    }

    public void setId_typeson(int id_typeson) {
        this.id_typeson = id_typeson;
    }

    public String getlinkMp3() {
        return linkMp3;
    }

    public void setlinkMp3(String linkMp3) {
        this.linkMp3 = linkMp3;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
