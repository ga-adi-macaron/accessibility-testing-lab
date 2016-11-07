package com.colinbradley.to_do_lists;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

/**
 * Created by colinbradley on 10/20/16.
 */

public class Item_Activity extends AppCompatActivity {

    public static final String INTENT = "listname";

    RecyclerView mRV;

    TextView mTitle;

    Button mAddItemButton, mBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent mIntent = getIntent();
        String name = mIntent.getStringExtra(INTENT);

        final LinkedList<Item_Data> itemlist = ToDoLists_Data.getInstance().getItemName(name);

        mRV = (RecyclerView)findViewById(R.id.itemRV);

        mTitle = (TextView)findViewById(R.id.thislist);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRV.setLayoutManager(linearLayoutManager);

        final Item_Adapter itemAdapter = new Item_Adapter(itemlist, Item_Activity.this);
        mRV.setAdapter(itemAdapter);

        mTitle.setText(name);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.addITEMbutton:
                        final AlertDialog.Builder itemInput = new AlertDialog.Builder(Item_Activity.this);
                        View view = getLayoutInflater().inflate(R.layout.activity_popup4item, null);

                        final EditText mInputItemName = (EditText)view.findViewById(R.id.inputItemName);

                        final EditText mInputItemDescription = (EditText)view.findViewById(R.id.inputItemDescription);

                        itemInput.setView(view).setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = mInputItemName.getText().toString();
                                String description = mInputItemDescription.getText().toString();
                                if (name.isEmpty()){
                                    Toast.makeText(Item_Activity.this, "Name of Item cannot be Blank", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    itemlist.add(new Item_Data(name,description));
                                    itemAdapter.notifyItemInserted(itemlist.size()-1);
                                }
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).create().show();
                        break;
                    case R.id.backButton:
                        finish();
                        break;
                }
            }
        };
        mAddItemButton = (Button)findViewById(R.id.addITEMbutton);

        mAddItemButton.setOnClickListener(onClickListener);

        mBackButton = (Button)findViewById(R.id.backButton);

        mBackButton.setOnClickListener(onClickListener);
    }
}
