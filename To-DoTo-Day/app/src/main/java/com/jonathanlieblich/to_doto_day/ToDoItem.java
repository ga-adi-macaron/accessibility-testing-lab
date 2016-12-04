package com.jonathanlieblich.to_doto_day;

/**
 * Created by jonlieblich on 10/19/16.
 */

public class ToDoItem {
    private String mTitle, mDescription;
    private boolean mComplete;

    public ToDoItem(String title, String description) {
        mDescription = description;
        mComplete = false;
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public void completed() {
        mComplete = !mComplete;
    }
}
