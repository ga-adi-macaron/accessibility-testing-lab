package com.elysium.didit;

/**
 * Created by jay on 10/31/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ToDoListViewHolder extends RecyclerView.ViewHolder {
    public Button mEditButton, mDeleteButton;
    public TextView mListTitle;
    public RelativeLayout mToDoListLayout;

    public ToDoListViewHolder(View itemView) {
        super(itemView);

        mEditButton = (Button)itemView.findViewById(R.id.edit_button);
        mDeleteButton = (Button)itemView.findViewById(R.id.delete_button);

        mListTitle = (TextView)itemView.findViewById(R.id.list_title);

        mToDoListLayout = (RelativeLayout)itemView.findViewById(R.id.recycler_list);
    }
}

