package shuvalov.nikita.todoornottodo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class SubListRecyclerAdapter extends RecyclerView.Adapter<SubListHolder> {
    private List<Errands> mErrandsList;
    private CheckBox checkBox;
    private RelativeLayout relativeLayout;
    private int mPosInSuperList;
    private TextView noteView;

    public SubListRecyclerAdapter(List<Errands> errandsList,int positionInSuperList) {
        mErrandsList = errandsList;
        mPosInSuperList = positionInSuperList;}

    @Override
    public SubListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sublist_form,null);
        return new SubListHolder(view);
    }

    @Override
    public void onBindViewHolder(final SubListHolder holder, final int position) { //
        noteView = (TextView)holder.itemView.findViewById(R.id.note);
        checkBox = (CheckBox)holder.itemView.findViewById(R.id.checkbox);
        relativeLayout = (RelativeLayout)holder.itemView.findViewById(R.id.sublistLayout);
        mErrandsList = MasterLister.getErrEncapInPosition(mPosInSuperList).getErrandsList();

        checkBox.setChecked(mErrandsList.get(position).getCheckedStatus());
        noteView.setText(mErrandsList.get(position).getText());
        View.OnClickListener toggleCheckbox = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MasterLister.getErrEncapInPosition(mPosInSuperList).getErrandsList().get(holder.getAdapterPosition()).toggleChecked();
                    notifyItemChanged(holder.getAdapterPosition());
                }
        };
        relativeLayout.setOnClickListener(toggleCheckbox);
        checkBox.setOnClickListener(toggleCheckbox);

        relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(v.getContext());
                LayoutInflater layoutInflater = new LayoutInflater(v.getContext()) {
                    @Override
                    public LayoutInflater cloneInContext(Context newContext) {
                        return null;
                    }
                };

                adb.setView(layoutInflater.inflate(R.layout.warn_form, null))
                        .setMessage("Delete item?")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MasterLister.getErrEncapInPosition(mPosInSuperList).removeErrandByPosition(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                            }
                        }).setNegativeButton("Nevermind", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog warnAlert = adb.create();
                warnAlert.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mErrandsList.size();
    }

}
