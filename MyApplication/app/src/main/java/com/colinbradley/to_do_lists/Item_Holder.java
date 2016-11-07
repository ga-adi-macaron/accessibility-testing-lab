package com.colinbradley.to_do_lists;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by colinbradley on 10/20/16.
 */

public class Item_Holder extends RecyclerView.ViewHolder {

    TextView mItemTitle, mDescription;

    RelativeLayout mRelativeLayout;

    Button mAddItemButton, mRemoveItemButton;


    public Item_Holder(View itemView) {
        super(itemView);

        mItemTitle = (TextView)itemView.findViewById(R.id.itemTitle);

        mDescription = (TextView)itemView.findViewById(R.id.itemDescription);

        mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.itemLayout);

        mAddItemButton = (Button)itemView.findViewById(R.id.addITEMbutton);

        mRemoveItemButton = (Button)itemView.findViewById(R.id.removeITEMbutton);
    }
}
