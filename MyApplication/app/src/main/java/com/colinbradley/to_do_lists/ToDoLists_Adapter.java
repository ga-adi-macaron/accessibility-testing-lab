package com.colinbradley.to_do_lists;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by colinbradley on 10/19/16.
 */

public class ToDoLists_Adapter extends RecyclerView.Adapter<ToDoLists_Holder> {

    public static final String INTENT = "listname";
    HashMap<String, LinkedList<Item_Data>> mToDoLists;
    final Context mContext;
    final Intent intent = new Intent();
    final RelativeLayout mLayout;

    public ToDoLists_Adapter(HashMap<String, LinkedList<Item_Data>> todoLists, Context context, RelativeLayout layout){
        mContext = context;

        mToDoLists = todoLists;

        mLayout = layout;

        intent.setClass(context, Item_Activity.class);
    }

    @Override
    public ToDoLists_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.list_layout, parent, false);

        return new ToDoLists_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(ToDoLists_Holder holder, final int position) {

        final String listName = ToDoLists_Data.getInstance().getmLists().get(position);

        holder.mTextView.setText(listName);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.removeLISTbutton:
                        ToDoLists_Data.getInstance().removeItemPosition(position);
                        notifyDataSetChanged();
                        Toast.makeText(mContext, listName + " has beed DELETED", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.layoutForListView:
                        intent.putExtra(INTENT, listName);
                        mContext.startActivity(intent);
                        break;
                }
            }
        };
        holder.mRelativeLayout.setOnClickListener(onClickListener);

        holder.mRemoveListButton.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mToDoLists.keySet().size();
    }
}
