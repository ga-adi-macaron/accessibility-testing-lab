package com.korbkenny.todotaketwo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by KorbBookProReturns on 10/20/16.
 */

public class ListActivity extends AppCompatActivity{

    private TextView mTitle;
    public BigOldListOfLists semiBigListofListsIguess;
    private Button mButton;
    private ListView mListOfItems;
    public ArrayAdapter<ToDoItem> mArrayAdapter2;
    private ArrayList<ToDoItem> mToDoItemLists;
    final Context context = this;
    private ToDoList current;
    private Button mBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //GET INTENT
        String title = getIntent().getStringExtra("Title");
        final int index = getIntent().getIntExtra("Index",-1);


        //REFERENCE STUFF
        mTitle = (TextView) findViewById(R.id.InsideTextView);
        mTitle.setText(title);
        mListOfItems = (ListView) findViewById(R.id.InsideListView);
        semiBigListofListsIguess = BigOldListOfLists.getInstance();
        mToDoItemLists = new ArrayList<ToDoItem>();

        mBackButton = (Button) findViewById(R.id.BackButton);
        current = semiBigListofListsIguess.getListOfLists().get(index);
        mToDoItemLists = current.getItems();

        //mToDoItemLists = bigOldListOfLists.getListOfLists().get(index);

        mButton = (Button) findViewById(R.id.insideAddItemButton);


        //CLICK ON BUTTON
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater theInflater2 = LayoutInflater.from(context);
                View datPrompt = theInflater2.inflate(R.layout.dialog_add_new_item, null);

                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(context);
                alertDialogBuilder2.setView(datPrompt);

                final EditText userInputTitle = (EditText) datPrompt
                        .findViewById(R.id.EnterTextForNewList2);
                final EditText userInputDescript = (EditText) datPrompt
                        .findViewById(R.id.EnterTextForItem2);

                alertDialogBuilder2
                        .setCancelable(false)
                        .setPositiveButton("Add",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(userInputTitle.getText().toString().trim().equals("")
                                                || userInputDescript.getText().toString().trim().equals("")){
                                            Toast.makeText(context, "Shoulda entered text...", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            mToDoItemLists.add(new ToDoItem(userInputTitle.getText().toString().toUpperCase(),
                                                    userInputDescript.getText().toString().toLowerCase()));
                                                    mArrayAdapter2.notifyDataSetChanged();
                                        }
                                    }
                                })
                        .setNegativeButton("Nevermind",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = alertDialogBuilder2.create();
                alertDialog.show();
            }
        });

        mListOfItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {


            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ToDoItem item = mArrayAdapter2.getItem(position);
                mToDoItemLists.remove(position);
                mArrayAdapter2.notifyDataSetChanged();
                return true;


            }
        });



        mArrayAdapter2 = new ArrayAdapter<ToDoItem>(context,android.R.layout.simple_list_item_2,android.R.id.text1,mToDoItemLists){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(mToDoItemLists.get(position).getItemName());
                text2.setText(mToDoItemLists.get(position).getItemDescript());
                return view;
            }
        };

        mListOfItems.setAdapter(mArrayAdapter2);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.setItems(mToDoItemLists);
                ListActivity.this.finish();
            }
        });

                  //  this.finish();

            }
        }



        //bigOldListOfLists.getListOfLists().get(index);




       // Intent receivedIntent = getIntent();

    //}
//}
