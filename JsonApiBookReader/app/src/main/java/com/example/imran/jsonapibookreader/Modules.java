package com.example.imran.jsonapibookreader;

import android.text.TextUtils;

/**
 * Created by imran on 9/20/2016.
 */
public class Modules {
    private String title;
    private String[] auther;
    private String imsge;
    private int date;

    public Modules(String title, String[] auther, String imsge, int date) {
        this.title = title;
        this.auther = auther;
        this.imsge = imsge;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return TextUtils.join(", ",auther);
    }

    public void setAuther(String[] auther) {
        this.auther = auther;
    }

    public String getImsge() {
        return imsge;
    }

    public void setImsge(String imsge) {
        this.imsge = imsge;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
