package com.example.imran.databaseproject;

/**
 * Created by imran on 8/29/2016.
 */
public class MyStucture {
    public String title;
    public String description;
    public int id;

    public MyStucture(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
