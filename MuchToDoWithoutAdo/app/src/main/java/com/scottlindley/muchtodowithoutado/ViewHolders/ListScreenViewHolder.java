package com.scottlindley.muchtodowithoutado.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.R;


/**
 * Created by Scott Lindley on 10/19/2016.
 */

public class ListScreenViewHolder extends RecyclerView.ViewHolder{
    public TextView mItemName;
    public TextView mItemDescription;
    public CheckBox mCheckBox;
    public RelativeLayout mRelativeLayout;
    public ImageView mInfoButton;


    public ListScreenViewHolder(View itemView) {
        super(itemView);

        mItemName = (TextView)itemView.findViewById(R.id.list_item_name);
        mItemDescription = (TextView)itemView.findViewById(R.id.list_item_description);
        mCheckBox = (CheckBox)itemView.findViewById(R.id.checkbox);
        mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.list_item_relative_layout);
        mInfoButton = (ImageView)itemView.findViewById(R.id.edit_icon);
    }


}
