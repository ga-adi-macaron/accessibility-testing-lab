package com.elysium.didit;

/**
 * Created by jay on 10/31/16.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListViewHolder> {
    List<ToDoList> mToDoLister;

    public ToDoListAdapter(List<ToDoList> toDoLister) {
        mToDoLister = toDoLister;
    }

    @Override
    public ToDoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View newView = inflater.inflate(R.layout.todo_list_item, parent, false);

        ToDoListViewHolder viewHolder = new ToDoListViewHolder(newView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ToDoListViewHolder holder, final int position) {
        final ToDoList newList = mToDoLister.get(position);

        holder.mListTitle.setText(mToDoLister.get(position).getListTitle());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case(R.id.edit_button):
                        Intent intent = new Intent(holder.mEditButton.getContext(), ListActivity.class);
                        intent.putExtra("ListPosition", holder.getAdapterPosition());
                        holder.mEditButton.getContext().startActivity(intent);
                        break;
                    case(R.id.delete_button):
                        mToDoLister.remove(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());
                        break;
                    default:
                        Toast.makeText(v.getContext(), "Please press a button", Toast.LENGTH_SHORT).show();
                }
            }
        };
        holder.mEditButton.setOnClickListener(onClickListener);
        holder.mDeleteButton.setOnClickListener(onClickListener);
        holder.mToDoListLayout.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mToDoLister.size();
    }
}

