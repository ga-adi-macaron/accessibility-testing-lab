package com.korbkenny.todotaketwo;

/**
 * Created by KorbBookProReturns on 10/20/16.
 */

public class ToDoItem{
    public String mItemName;
    public String mItemDescript;

    public ToDoItem(String itemName, String itemDescript){
        mItemName = itemName;
        mItemDescript = itemDescript;
    }

    public String getItemName() {
        return mItemName;
    }

    public String getItemDescript() {
        return mItemDescript;
    }

    public void setItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public void setItemDescript(String mItemDescript) {
        this.mItemDescript = mItemDescript;
    }
}
