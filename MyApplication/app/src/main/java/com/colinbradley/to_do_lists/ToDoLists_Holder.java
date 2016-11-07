package com.colinbradley.to_do_lists;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by colinbradley on 10/19/16.
 */

public class ToDoLists_Holder extends RecyclerView.ViewHolder {

    public TextView mTextView;

    public RelativeLayout mRelativeLayout;

    public Button mRemoveListButton;


    public ToDoLists_Holder(View itemView) {
        super(itemView);

        mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.layoutForListView);

        mTextView = (TextView)itemView.findViewById(R.id.list);

        mRemoveListButton = (Button)itemView.findViewById(R.id.removeLISTbutton);

    }
}
