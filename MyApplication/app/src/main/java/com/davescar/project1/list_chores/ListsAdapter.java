package com.davescar.project1.list_chores;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davescar.project1.ListOfChoresActivity;
import com.davescar.project1.R;
import com.davescar.project1.list_chores.ChoreList;
import com.davescar.project1.list_chores.ListHolder;

import java.util.List;

/**
 * Created by ds on 10/20/16.
 */

public class ListsAdapter extends RecyclerView.Adapter<ListHolder> {

    List<ChoreList> mListOfLists;

    public ListsAdapter(List<ChoreList> listOfLists) {
        mListOfLists = listOfLists;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_of_lists, parent, false);
        ListHolder viewHolder = new ListHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListHolder holder, final int position) {
        holder.getTitle().setText(mListOfLists.get(position).getNameOfList());
        holder.getTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),ListOfChoresActivity.class);
                intent.putExtra("positionKey",position);
                view.getContext().startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mListOfLists.remove(position);
                notifyItemRemoved(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListOfLists.size();
    }
}
