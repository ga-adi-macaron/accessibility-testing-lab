package com.davescar.project1.chore;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davescar.project1.R;

import java.util.List;

/**
 * Created by ds on 10/20/16.
 */

public class ChoreAdapter extends RecyclerView.Adapter<ChoreHolder> {

    private List<Chore> mChoreList;

    public ChoreAdapter(List<Chore> choreList) {
        mChoreList = choreList;
    }

    @Override
    public ChoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewofchore, parent, false);
        ChoreHolder viewHolder = new ChoreHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChoreHolder holder, final int position) {
        holder.mTitle.setText(mChoreList.get(position).getTitle());
        holder.mDescription.setText(mChoreList.get(position).getDescription());
        holder.mDone.setChecked(mChoreList.get(position).isDone());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mChoreList.remove(position);
                notifyItemRemoved(position);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mChoreList.size();
    }





}
