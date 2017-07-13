package com.swings.jam.data;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by sonnguyen on 7/12/17.
 */

public class YourJam {
    private int idJam,idBackingTrack;
    private String name;
    private String fileLink;
    private long time;

    public YourJam(int idBackingTrack, String name, String fileLink) {
        this.idBackingTrack = idBackingTrack;
        this.name = name;
        this.fileLink = fileLink;
        this.time = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
    }
    public YourJam(int idBackingTrack, String name, String fileLink, long time) {
        this.idBackingTrack = idBackingTrack;
        this.name = name;
        this.fileLink = fileLink;
        this.time = time;
    }

    public YourJam() {

    }

    public int getIdJam() {
        return idJam;
    }

    public void setIdJam(int idJam) {
        this.idJam = idJam;
    }

    public int getIdBackingTrack() {
        return idBackingTrack;
    }

    public void setIdBackingTrack(int idBackingTrack) {
        this.idBackingTrack = idBackingTrack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
