package com.jonathanlieblich.to_doto_day;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jonlieblich on 10/20/16.
 */

public class ToDoItemViewHolder extends RecyclerView.ViewHolder {
    public TextView mItemName, mItemDescription;
    public LinearLayout mToDoItem;

    public ToDoItemViewHolder(View itemView) {
        super(itemView);

        mItemDescription = (TextView)itemView.findViewById(R.id.item_description);
        mItemName = (TextView)itemView.findViewById(R.id.item_name);

        mToDoItem = (LinearLayout)itemView.findViewById(R.id.todo_item);
    }
}
