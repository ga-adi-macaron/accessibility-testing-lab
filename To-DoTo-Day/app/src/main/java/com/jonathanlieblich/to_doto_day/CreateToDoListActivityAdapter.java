package com.jonathanlieblich.to_doto_day;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonlieblich on 10/20/16.
 */

public class CreateToDoListActivityAdapter extends RecyclerView.Adapter<ToDoItemViewHolder> {
    List<ToDoItem> mToDoItems;

    public CreateToDoListActivityAdapter(List<ToDoItem> toDoList) {
        mToDoItems = toDoList;
    }

    @Override
    public ToDoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View newView = inflater.inflate(R.layout.todo_item, parent, false);

        ToDoItemViewHolder viewHolder = new ToDoItemViewHolder(newView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ToDoItemViewHolder holder, final int position) {
        final ToDoItem toDoItem = mToDoItems.get(position);

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
