package com.colinbradley.to_do_lists;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by colinbradley on 10/19/16.
 */
public class ToDoLists_Data {

    private static ToDoLists_Data toDoListsData = new ToDoLists_Data();

    private static LinkedList<String> mLists;

    private static HashMap<String, LinkedList<Item_Data>> mItem;

    public static ToDoLists_Data getInstance() {
        return toDoListsData;
    }

    private ToDoLists_Data(){
        mLists = new LinkedList<>();
        mItem = new HashMap<>();
    }

    public void createNewList(String list){
        mLists.add(list);
        mItem.put(list, new LinkedList<Item_Data>());
    }

    public LinkedList<String> getmLists(){
        return mLists;
    }

    public LinkedList<Item_Data> getItemName(String name){
        return mItem.get(name);
    }

    public static HashMap<String, LinkedList<Item_Data>> getHashMap(){
        return mItem;
    }

    public void removeItemPosition(int position){
        mItem.remove(mLists.get(position));
        mLists.remove(position);
    }
}
