package com.scottlindley.muchtodowithoutado.JavaObjects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Scott Lindley on 10/18/2016.
 */
public class ToDoListCollection implements Serializable{
    private static ToDoListCollection ourInstance;
    private ArrayList<ToDoList> mLists;



    public static ToDoListCollection getInstance() {
        if(ourInstance==null){
            ourInstance = new ToDoListCollection();
        }
        return ourInstance;
    }

    private ToDoListCollection() {
        mLists = new ArrayList<>();
    }


    public ArrayList<ToDoList> getLists(){
        return mLists;
    }


}
