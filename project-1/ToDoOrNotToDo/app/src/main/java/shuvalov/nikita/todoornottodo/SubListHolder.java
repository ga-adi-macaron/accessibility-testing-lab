package shuvalov.nikita.todoornottodo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class SubListHolder extends RecyclerView.ViewHolder{
    TextView noteContent;
    RelativeLayout relativeLayout;
    CheckBox checkBox;

    public SubListHolder(View itemView) {
        super(itemView);
        noteContent = (TextView)itemView.findViewById(R.id.note);
        relativeLayout=(RelativeLayout)itemView.findViewById(R.id.sublistLayout);
        checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
    }
}
