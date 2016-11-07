package com.colinbradley.to_do_lists;

/**
 * Created by colinbradley on 10/20/16.
 */

public class Item_Data {

    private String mItemTitle, mDescription;

    public Item_Data(String itemTitle, String description){
        mDescription = description;
        mItemTitle = itemTitle;
    }

    public String getmItemTitle(){
        return mItemTitle;
    }

    public void setmItemTitle(String itemTitle){
        mItemTitle = itemTitle;
    }

    public String getmDescription(){
        return mDescription;
    }

    public void setmDescription(String description){
        mDescription = description;
    }

}
