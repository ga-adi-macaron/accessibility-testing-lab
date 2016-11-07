package shuvalov.nikita.todoornottodo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class ListTitleHolder extends RecyclerView.ViewHolder{
    TextView titleView, descriptView;
    RelativeLayout relativeLayout;

    public ListTitleHolder(View itemView) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.listTitle);
        descriptView= (TextView) itemView.findViewById(R.id.descript);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.superlistitem);
    }
}
