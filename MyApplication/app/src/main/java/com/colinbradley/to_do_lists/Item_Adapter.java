package com.colinbradley.to_do_lists;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.nio.BufferUnderflowException;
import java.util.LinkedList;

/**
 * Created by colinbradley on 10/20/16.
 */

public class Item_Adapter extends RecyclerView.Adapter<Item_Holder> {

    LinkedList<Item_Data> mItems;

    private final Activity mContext;

    EditText mItemTitle;

    EditText mDescription;


    public Item_Adapter(LinkedList<Item_Data> items, Activity context){
        mItems = items;
        mContext = context;
    }

    @Override
    public Item_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new Item_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Item_Holder holder, int position) {
        final Item_Data item = mItems.get(position);

        holder.mDescription.setText(item.getmDescription());
        holder.mItemTitle.setText(item.getmItemTitle());

        mItemTitle = (EditText)mContext.findViewById(R.id.inputItemName);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.removeITEMbutton:
                        mItems.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
                        Toast.makeText(mContext,"Item has been REMOVED", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        holder.mRemoveItemButton.setOnClickListener(onClickListener);

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
