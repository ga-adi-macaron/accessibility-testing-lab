package com.korbkenny.todotaketwo;

import java.util.ArrayList;

/**
 * Created by KorbBookProReturns on 10/20/16.
 */
public class BigOldListOfLists {
    private static BigOldListOfLists ourInstance;
    private ArrayList<ToDoList> listOfLists;

    public static BigOldListOfLists getInstance() {
        if(ourInstance == null){
            ourInstance = new BigOldListOfLists();
        }
        return ourInstance;
    }

    private BigOldListOfLists() {
        listOfLists = new ArrayList<>();
    }

    public ArrayList<ToDoList> getListOfLists(){
        return listOfLists;
    }
}
