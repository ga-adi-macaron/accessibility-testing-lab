package com.colinbradley.to_do_lists;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToDoLists_Activity_main extends AppCompatActivity {

    private static final String INTENT = "listname";

    Button mAddListButton, mRemoveListButton;

    ToDoLists_Data mToDoLists_Data;

    RelativeLayout mRelativeLayout;

    RecyclerView mRV;

    EditText mInputListName;

    Context mContext;

    ToDoLists_Adapter toDoLists_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_lists);


        mRV = (RecyclerView)findViewById(R.id.listview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRV.setLayoutManager(linearLayoutManager);

        final ToDoLists_Adapter toDoLists_adapter = new ToDoLists_Adapter(mToDoLists_Data.getHashMap(),this, mRelativeLayout);

        mInputListName = (EditText)findViewById(R.id.inputNewLISTname);

        mAddListButton = (Button)findViewById(R.id.addListButton);

        mRemoveListButton = (Button)findViewById(R.id.removeLISTbutton);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_to_do_lists);

        mRV.setAdapter(toDoLists_adapter);

        mToDoLists_Data = ToDoLists_Data.getInstance();

        mAddListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder popup = new AlertDialog.Builder(ToDoLists_Activity_main.this);
                LayoutInflater inflater = ToDoLists_Activity_main.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.activity_popup4list,null);

                mInputListName = (EditText)view.findViewById(R.id.inputNewLISTname);
                if (mInputListName.requestFocus()){
                    InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.showSoftInput(mInputListName, InputMethodManager.SHOW_IMPLICIT);
                }

                popup.setView(view).setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = mInputListName.getText().toString();
                        if (name.isEmpty()){
                            Toast.makeText(ToDoLists_Activity_main.this, "Invalid Response No Item Can Be Empty", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mToDoLists_Data.createNewList(name);
                            toDoLists_adapter.notifyDataSetChanged();
                        }
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();
            }
        });
    }

}
