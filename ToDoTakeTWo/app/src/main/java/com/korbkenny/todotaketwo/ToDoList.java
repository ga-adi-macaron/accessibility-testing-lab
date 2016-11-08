package com.korbkenny.todotaketwo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by KorbBookProReturns on 10/20/16.
 */

public class ToDoList implements Serializable{
    private String mTitle;
    private ArrayList<ToDoItem> mItems;

    public ToDoList(String title){
        mTitle = title;
        mItems = new ArrayList<>();
    }

    public String getTitle() {
        return mTitle;
    }

    public ArrayList<ToDoItem> getItems() {
        return mItems;
    }

    public void setTitle(String Title) {
        mTitle = Title;
    }

    public void setItems(ArrayList<ToDoItem> Items) {
        mItems = Items;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
