package com.elysium.didit;

/**
 * Created by jay on 10/31/16.
 */

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<ToDoItems> mToDoItems;
    private String mListTitle;
    private boolean mListComplete;

    public ToDoList(String title) {
        mListComplete = false;
        mListTitle = title;
        mToDoItems = new ArrayList<>();
    }

    public void addItem(ToDoItems item) {
        mToDoItems.add(item);
    }

    public List<ToDoItems> getToDoItems() {
        return mToDoItems;
    }

    public String getListTitle() {
        return mListTitle;
    }

    public void setListTitle(String title) {
        mListTitle = title;
    }

    public boolean isListComplete() {
        return mListComplete;
    }

    public void listComplete() {
        mListComplete = !isListComplete();
    }
}

