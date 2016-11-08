package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jay on 10/31/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<ToDoItems> mToDoItems;

   public ListAdapter(List<ToDoItems> toDoList) {
        mToDoItems = toDoList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View newView = inflater.inflate(R.layout.to_do_items, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(newView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        final ToDoItems toDoItem = mToDoItems.get(position);

        holder.mItemName.setText(toDoItem.getTitle());
        holder.mItemDescription.setText(toDoItem.getDescription());

        holder.mToDoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToDoItems.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mToDoItems.size();
    }
}


