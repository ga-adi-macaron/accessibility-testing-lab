package com.elysium.didit;

/**
 * Created by jay on 10/31/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    public TextView mItemName, mItemDescription;
    public LinearLayout mToDoItem;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mItemDescription = (TextView) itemView.findViewById(R.id.item_description);
        mItemName = (TextView) itemView.findViewById(R.id.item_name);

        mToDoItem = (LinearLayout) itemView.findViewById(R.id.todo_item);
    }
}

