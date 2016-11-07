package com.jonathanlieblich.to_doto_day;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonlieblich on 10/20/16.
 */
public class ListOfLists {
    private static ListOfLists listOfLists = null;
    private static List<ToDoList> toDoLists;
    private static String listOfItemsTitle;

    private ListOfLists() {
        toDoLists = new ArrayList<>();
    }

    public static ListOfLists getInstance() {
        if(listOfLists == null)
            listOfLists = new ListOfLists();
        return listOfLists;
    }

    public List<ToDoList> getToDoLists() {
        return toDoLists;
    }

    public void addToDoList(String title) {
        toDoLists.add(new ToDoList(title));
    }

    public void setToDoList(List<ToDoList> toDoLister) {
        toDoLists = toDoLister;
    }

    public void setListTtitle(String title) {
        listOfItemsTitle = title;
    }

    public String getListTitle() {
        return listOfItemsTitle;
    }
}
