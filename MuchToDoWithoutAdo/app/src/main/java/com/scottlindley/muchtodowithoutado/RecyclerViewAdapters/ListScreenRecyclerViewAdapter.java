package com.scottlindley.muchtodowithoutado.RecyclerViewAdapters;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDo;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.ViewHolders.ListScreenViewHolder;

import java.util.ArrayList;

import static com.scottlindley.muchtodowithoutado.Activities.HomeActivity.mData;

/**
 * Created by Scott Lindley on 10/19/2016.
 */

public class ListScreenRecyclerViewAdapter extends RecyclerView.Adapter<ListScreenViewHolder>{
    private ArrayList<ToDo> mItems;

    public ListScreenRecyclerViewAdapter(int positionNumber) {
        mItems = mData.getLists().get(positionNumber).getItems();
    }

    @Override
    public ListScreenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View returnView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_layout, parent, false);
        return  new ListScreenViewHolder(returnView);
    }

    @Override
    public void onBindViewHolder(final ListScreenViewHolder holder, final int position) {
        final View.OnClickListener editItemClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());

                LayoutInflater inflater = LayoutInflater.from(view.getContext());
                final View dialogView = (inflater.inflate(R.layout.edit_list_item_dialog, null));
                dialogBuilder.setView(dialogView);
                final EditText itemName = (EditText) dialogView.findViewById(R.id.new_todo);
                final EditText itemDescription = (EditText) dialogView.findViewById(R.id.details);
                final RadioButton lowPriority = (RadioButton) dialogView.findViewById(R.id.low_priority);
                final RadioButton mediumPriority = (RadioButton) dialogView.findViewById(R.id.medium_priority);
                final RadioButton highPriority = (RadioButton) dialogView.findViewById(R.id.high_priority);

                itemName.setHint(mItems.get(holder.getAdapterPosition()).mItemName);
                itemDescription.setHint(mItems.get(holder.getAdapterPosition()).mItemDescription);


                dialogBuilder.setNegativeButton("cancel", null);
                dialogBuilder.setPositiveButton("okay", null);

                setRadioButtonClickListeners(lowPriority, mediumPriority, highPriority);
                final AlertDialog dialog = dialogBuilder.create();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        dialog.getButton(Dialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (itemName.getText().toString().equals("")) {
                                    itemName.setError("Name cannot be blank");
                                } else {
                                    mItems.get(holder.getAdapterPosition()).mItemName = itemName.getText().toString();
                                    mItems.get(holder.getAdapterPosition()).mItemDescription = itemDescription.getText().toString();
                                    notifyItemChanged(holder.getAdapterPosition());

                                    int priority;
                                    if (lowPriority.isChecked()) {
                                        priority = 0;
                                    } else if (mediumPriority.isChecked()) {
                                        priority = 1;
                                    } else if (highPriority.isChecked()) {
                                        priority = 2;
                                    } else {
                                        priority = 0;
                                    }
                                    ToDo addedToDo = mItems.get(mItems.size() - 1);
                                    switch (priority) {
                                        case 0:
                                            addedToDo.mPriority = 0;
                                            notifyItemChanged(holder.getAdapterPosition());
                                            break;
                                        case 1:
                                            addedToDo.mPriority = 1;
                                            notifyItemChanged(holder.getAdapterPosition());
                                            break;
                                        case 2:
                                            addedToDo.mPriority = 2;
                                            notifyItemChanged(holder.getAdapterPosition());
                                            break;
                                    }
                                    dialog.dismiss();
                                }


                            }
                        });
                    }
                });
                dialog.show();
            }
        };


        holder.mItemName.setText(mItems.get(holder.getAdapterPosition()).mItemName);
        holder.mItemDescription.setText(mItems.get(holder.getAdapterPosition()).mItemDescription);
        holder.mCheckBox.setChecked(mItems.get(holder.getAdapterPosition()).mIsChecked);
        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mItems.get(holder.getAdapterPosition()).mIsChecked) {
                    mItems.get(holder.getAdapterPosition()).mIsChecked = true;
                    notifyItemChanged(holder.getAdapterPosition());
                } else {
                    mItems.get(holder.getAdapterPosition()).mIsChecked = false;
                    notifyItemChanged(holder.getAdapterPosition());
                }
            }
        });

        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mRelativeLayout.setOnClickListener(editItemClickListener);

                holder.mInfoButton.setVisibility(View.VISIBLE);
                holder.mInfoButton.setClickable(true);
                holder.mInfoButton.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.mInfoButton.setVisibility(View.INVISIBLE);
                        holder.mInfoButton.setClickable(false);
                    }
                }, 4000);
            }
        });

        holder.mRelativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mItems.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                return true;
            }
        });

        holder.mInfoButton.setOnClickListener(editItemClickListener);

//        holder.mInfoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
//
//                LayoutInflater inflater = LayoutInflater.from(view.getContext());
//                final View dialogView = (inflater.inflate(R.layout.edit_list_item_dialog, null));
//                dialogBuilder.setView(dialogView);
//                final EditText itemName = (EditText) dialogView.findViewById(R.id.new_todo);
//                final EditText itemDescription = (EditText) dialogView.findViewById(R.id.details);
//                final RadioButton lowPriority = (RadioButton) dialogView.findViewById(R.id.low_priority);
//                final RadioButton mediumPriority = (RadioButton) dialogView.findViewById(R.id.medium_priority);
//                final RadioButton highPriority = (RadioButton) dialogView.findViewById(R.id.high_priority);
//
//                itemName.setHint(mItems.get(holder.getAdapterPosition()).mItemName);
//                itemDescription.setHint(mItems.get(holder.getAdapterPosition()).mItemDescription);
//
//
//                dialogBuilder.setNegativeButton("cancel", null);
//                dialogBuilder.setPositiveButton("okay", null);
//
//                setRadioButtonClickListeners(lowPriority, mediumPriority, highPriority);
//                final AlertDialog dialog = dialogBuilder.create();
//                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
//
//
//                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//                    @Override
//                    public void onShow(DialogInterface dialogInterface) {
//                        dialog.getButton(Dialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                dialog.dismiss();
//                            }
//                        });
//                        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (itemName.getText().toString().equals("")) {
//                                    itemName.setError("Name cannot be blank");
//                                } else {
//                                    mItems.get(holder.getAdapterPosition()).mItemName = itemName.getText().toString();
//                                    mItems.get(holder.getAdapterPosition()).mItemDescription = itemDescription.getText().toString();
//                                    notifyItemChanged(holder.getAdapterPosition());
//
//                                    int priority;
//                                    if (lowPriority.isChecked()) {
//                                        priority = 0;
//                                    } else if (mediumPriority.isChecked()) {
//                                        priority = 1;
//                                    } else if (highPriority.isChecked()) {
//                                        priority = 2;
//                                    } else {
//                                        priority = 0;
//                                    }
//                                    ToDo addedToDo = mItems.get(mItems.size() - 1);
//                                    switch (priority) {
//                                        case 0:
//                                            addedToDo.mPriority = 0;
//                                            notifyItemChanged(holder.getAdapterPosition());
//                                            break;
//                                        case 1:
//                                            addedToDo.mPriority = 1;
//                                            notifyItemChanged(holder.getAdapterPosition());
//                                            break;
//                                        case 2:
//                                            addedToDo.mPriority = 2;
//                                            notifyItemChanged(holder.getAdapterPosition());
//                                            break;
//                                    }
//                                    dialog.dismiss();
//                                }
//
//
//                            }
//                        });
//                    }
//                });
//                dialog.show();
//            }
//        });

        if(!holder.mCheckBox.isChecked()){
            holder.mCheckBox.setChecked(false);
            holder.mItemName.setAlpha(1.0f);
            holder.mItemDescription.setAlpha(1.0f);
        }else if(holder.mCheckBox.isChecked()){
            holder.mCheckBox.setChecked(true);
            holder.mItemName.setAlpha(0.4f);
            holder.mItemDescription.setAlpha(0.4f);
        }

        switch (mItems.get(position).mPriority){
            case 0:
                holder.mItemName.setTextColor(Color.rgb(69,69,69));
                break;
            case 1:
                holder.mItemName.setTextColor(Color.rgb(214,153,2));
                break;
            case 2:
                holder.mItemName.setTextColor(Color.rgb(195,0,0));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setRadioButtonClickListeners(final RadioButton low, final RadioButton medium, final RadioButton high) {
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(true);
                medium.setChecked(false);
                high.setChecked(false);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(false);
                medium.setChecked(true);
                high.setChecked(false);
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(false);
                medium.setChecked(false);
                high.setChecked(true);
            }
        });
    }

}
