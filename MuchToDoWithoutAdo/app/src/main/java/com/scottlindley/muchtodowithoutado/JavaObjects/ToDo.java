package com.scottlindley.muchtodowithoutado.JavaObjects;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class ToDo {
    public String mItemName;
    public String mItemDescription;
    public int mPriority;
    public boolean mIsChecked;
    public static final int HIGH_PRIORITY = 2;
    public static final int MEDIUM_PRIORITY = 1;
    public static final int LOW_PRIORITY = 0;

    public ToDo(String itemName, String itemDescription) {
        mItemName = itemName;
        mItemDescription = itemDescription;
        mPriority = LOW_PRIORITY;
        mIsChecked = false;}



}
