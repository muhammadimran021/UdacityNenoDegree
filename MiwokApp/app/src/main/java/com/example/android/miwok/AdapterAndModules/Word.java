package com.example.android.miwok.AdapterAndModules;

/**
 * Created by Kamran ALi on 8/1/2016.
 */
public class Word {
    public static final int no_imageProvided = -1;
    private String defaultTranslation;
    private String pashtoTranslation;
    private int mAudioResourceID;
    private int imageResourceID = no_imageProvided;

    public Word(String defaultTranslation, String pashtoTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.pashtoTranslation = pashtoTranslation;
    }

    public Word(String defaultTranslation, String pashtoTranslation, int imageResourceID, int audioResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.pashtoTranslation = pashtoTranslation;
        this.imageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
    }

    public Word(String defaultTranslation, String pashtoTranslation, int imageResourceID) {
        this.defaultTranslation = defaultTranslation;
        this.pashtoTranslation = pashtoTranslation;
        this.imageResourceID = imageResourceID;
    }

    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public String getPashtoTranslation() {
        return pashtoTranslation;
    }

    public boolean hasImage() {
        return imageResourceID != no_imageProvided;
    }
}
