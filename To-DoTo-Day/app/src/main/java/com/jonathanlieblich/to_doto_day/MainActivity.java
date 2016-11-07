package com.jonathanlieblich.to_doto_day;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView toDoListRecycler;
    FloatingActionButton mAddNewList;
    List<ToDoList> mToDoLists;
    final static int LIST_RESULT = 25;
    final static int NEW_LIST_RESULT = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToDoLists = ListOfLists.getInstance().getToDoLists();

        mAddNewList = (FloatingActionButton) findViewById(R.id.floating_add);

        mAddNewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alert dialog for title, call addNewList
                AlertDialog.Builder createNewList = new AlertDialog.Builder(MainActivity.this);
                createNewList.setTitle("Enter List Name");
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                createNewList.setView(inflater.inflate(R.layout.alert_dialog_list_title, null))
                        .setPositiveButton("create", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Dialog newDialog = (Dialog)dialog;
                                EditText title = (EditText)newDialog.findViewById(R.id.new_title);
                                ListOfLists.getInstance().addToDoList(title.getText().toString());
                                Intent intent = new Intent(MainActivity.this, CreateToDoListActivity.class);
                                intent.putExtra("ListPosition", ListOfLists.getInstance().getToDoLists().size()-1);
                                toDoListRecycler.getAdapter().notifyItemInserted(ListOfLists.getInstance().getToDoLists().size()-1);
                                startActivity(intent);
                            }
                        });
                AlertDialog dialog = createNewList.create();
                dialog.show();
            }
        });

        toDoListRecycler = (RecyclerView) findViewById(R.id.list_of_lists);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        toDoListRecycler.setLayoutManager(layoutManager);

        toDoListRecycler.setAdapter(new ToDoListAdapter(mToDoLists));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == LIST_RESULT) {
            if(resultCode == RESULT_OK) {

            }

        } else if(requestCode == NEW_LIST_RESULT) {
            if(resultCode == RESULT_OK) {

            }
        }
    }
}
