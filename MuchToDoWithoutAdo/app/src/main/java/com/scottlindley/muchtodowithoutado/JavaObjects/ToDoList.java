package com.scottlindley.muchtodowithoutado.JavaObjects;

import java.util.ArrayList;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class ToDoList {
    private String mName;
    private ArrayList<ToDo> mItems;

    public ToDoList(String name) {
        mName = name;
        mItems = new ArrayList<>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<ToDo> getItems() {
        return mItems;
    }

    public void setItems(ArrayList<ToDo> items) {
        mItems = items;
    }
}
