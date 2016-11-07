package com.scottlindley.muchtodowithoutado.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.R;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class HomeScreenViewHolder extends RecyclerView.ViewHolder{
    public TextView mHomeListName;
    public RelativeLayout mRelativeLayout;

    public HomeScreenViewHolder(View itemView) {
        super(itemView);

        mHomeListName = (TextView)itemView.findViewById(R.id.home_list_name);
        mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.home_list_layout);
    }

}
