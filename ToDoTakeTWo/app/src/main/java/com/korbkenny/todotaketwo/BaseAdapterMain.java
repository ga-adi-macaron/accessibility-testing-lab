package com.korbkenny.todotaketwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KorbBookProReturns on 10/21/16.
 */

public class BaseAdapterMain extends BaseAdapter
{
    BigOldListOfLists bigOldListOfLists;
    ArrayList<ToDoList> toDoListArray;
    LayoutInflater inflater;
    Context context;

    public BaseAdapterMain (Context context, ArrayList<ToDoList> toDoListArray){
        //
        this.toDoListArray = toDoListArray;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return (toDoListArray == null) ? 0 : toDoListArray.size();
    }

    @Override
    public Object getItem(int position) {
            return toDoListArray.get(position);
        }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_lists_item_main, parent, false);
            myViewHolder = new MyViewHolder();
            convertView.setTag(myViewHolder);
        }
        else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        myViewHolder.theTitle = (TextView) convertView.findViewById(R.id.OneList);
        myViewHolder.theTitle.setText(toDoListArray.get(position).getTitle());

        return convertView;
    }

    private static class MyViewHolder {
        TextView theTitle;
    }
}
