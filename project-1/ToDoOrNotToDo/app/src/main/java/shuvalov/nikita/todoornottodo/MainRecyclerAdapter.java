package shuvalov.nikita.todoornottodo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<ListTitleHolder> {
    private List<ErrandsEncapsulator> mErrandsEncapsulatorList;



    public MainRecyclerAdapter(List<ErrandsEncapsulator> errandsEncapsulatorList) {mErrandsEncapsulatorList=errandsEncapsulatorList;}

    @Override
    public ListTitleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_form,null);
        return new ListTitleHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListTitleHolder holder, final int position) {
        TextView titleView = (TextView) holder.itemView.findViewById(R.id.listTitle);
        TextView descriptView = (TextView) holder.itemView.findViewById(R.id.descript);

        RelativeLayout relativeLayout =(RelativeLayout)holder.itemView.findViewById(R.id.superlistitem);

        titleView.setText(mErrandsEncapsulatorList.get(position).getTitle());
        descriptView.setText(mErrandsEncapsulatorList.get(position).getDescription());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SubListActivity.class);
                intent.putExtra("Position", position);
                intent.putExtra("ListName", mErrandsEncapsulatorList.get(position).getTitle());
                v.getContext().startActivity(intent);
            }
        });
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder warnBuilder = new AlertDialog.Builder(v.getContext());
                LayoutInflater inflater = new LayoutInflater(v.getContext()) {
                    @Override
                    public LayoutInflater cloneInContext(Context newContext) {
                        return null;
                    }
                };
                warnBuilder.setView(inflater.inflate(R.layout.warn_form,null))
                        .setPositiveButton("Delete list", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MasterLister.removeToDoList(position);
                                notifyItemRemoved(holder.getAdapterPosition());
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                .setMessage("Delete list and its contents?");
                AlertDialog warnAlert = warnBuilder.create();
                warnAlert.show();
                return false;
            }
        };
        relativeLayout.setOnLongClickListener(onLongClickListener);
    }

    @Override
    public int getItemCount() { return mErrandsEncapsulatorList.size();}
}
