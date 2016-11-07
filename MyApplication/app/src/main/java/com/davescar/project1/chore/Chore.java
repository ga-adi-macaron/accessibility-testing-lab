package com.davescar.project1.chore;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by ds on 10/19/16.
 */

public class Chore {

    private String mTitle;
    private String mDescription;
    private boolean mDone;

    public Chore(String title, String description, boolean done) {
        mTitle = title;
        mDescription = description;
        mDone = done;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isDone() {
        return mDone;
    }

    public void setDone(boolean done) {
        mDone = done;
    }
}





