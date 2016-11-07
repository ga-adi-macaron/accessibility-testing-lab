package com.jonathanlieblich.to_doto_day;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonlieblich on 10/19/16.
 */

public class ToDoList {
    private List<ToDoItem> mToDoItems;
    private String mListTitle;
    private boolean mListComplete;

    public ToDoList(String title) {
        mListComplete = false;
        mListTitle = title;
        mToDoItems = new ArrayList<>();
    }

    public void addItem(ToDoItem item) {
        mToDoItems.add(item);
    }

    public List<ToDoItem> getToDoItems() {
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
