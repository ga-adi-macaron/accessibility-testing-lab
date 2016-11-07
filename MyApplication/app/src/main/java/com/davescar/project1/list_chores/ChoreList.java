package com.davescar.project1.list_chores;

import com.davescar.project1.chore.Chore;

import java.util.ArrayList;

/**
 * Created by ds on 10/19/16.
 */

public class ChoreList {

    private ArrayList<Chore> mChoreList;
    private String mNameOfList;


    public ChoreList(String nameOfList) {
        mChoreList = new ArrayList<>();
        mNameOfList = nameOfList;


    }

    public ArrayList<Chore> getChoreList() {
        return mChoreList;
    }

    public String getNameOfList() {
        return mNameOfList;
    }

    public void setNameOfList(String nameOfList) {
        mNameOfList = nameOfList;

    }

    public void makeNewChore(Chore chore) {
        mChoreList.add(chore);
    }
}

