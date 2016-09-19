package com.android.tourguideapp;

/**
 * Created by Kamran ALi on 8/2/2016.
 */
public class Description {
    private String placeName;
    private String description;
    private String locaton;
    private int imageResourceID;

    public Description(String placeName, String description, String locaton, int imageResourceID) {
        this.placeName = placeName;
        this.description = description;
        this.locaton = locaton;
        this.imageResourceID = imageResourceID;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocaton() {
        return locaton;
    }
}
