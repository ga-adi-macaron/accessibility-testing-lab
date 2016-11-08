package com.elysium.didit;

/**
 * Created by jay on 10/20/16.
 */

public class ToDoItems {
    private String mTitle, mDescription;
    private boolean mComplete;

    public ToDoItems(String title, String description) {
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
