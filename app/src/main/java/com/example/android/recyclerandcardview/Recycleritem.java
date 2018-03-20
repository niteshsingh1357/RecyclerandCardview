package com.example.android.recyclerandcardview;

/**
 * Created by nitesh on 2/6/18.
 */

public class Recycleritem {

    private String title;
    private String description;

    public Recycleritem(String title, String description) {
        this.title = title;
        this.description = description;
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
}
