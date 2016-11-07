package com.davescar.project1;

import com.davescar.project1.list_chores.ChoreList;

import java.util.ArrayList;

/**
 * Created by ds on 10/19/16.
 */

public class ListOfTheLists {

    private static ListOfTheLists listOfTheLists = null;
    private static ArrayList<ChoreList> mListOfTheLists;


    private ListOfTheLists() {
        mListOfTheLists = new ArrayList<>();
    }

    public static ListOfTheLists getInstance () {
        if (listOfTheLists == null) {
            listOfTheLists = new ListOfTheLists();
        }

        return listOfTheLists;
    }

    public ArrayList<ChoreList> getmListOfTheLists() {
        return mListOfTheLists;
    }

    public void makeNewList(ChoreList newChoreList){
        mListOfTheLists.add(newChoreList);
    }
}


