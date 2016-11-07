package com.scottlindley.muchtodowithoutado.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDo;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.ListScreenRecyclerViewAdapter;

import static com.scottlindley.muchtodowithoutado.Activities.HomeActivity.mData;
import static com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.HomeRecyclerViewAdapter.POSITION_NUMBER;

public class ToDoListActivity extends AppCompatActivity {
    private int mPositionNumber;
    private RecyclerView mRecyclerView;
    private TextView mListName;
    private TextView mSplashText;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        /*
        Grab the position number from the clicked list through the previous activity's intent.
        If the list was just created, the default position number is the last index of the list
         */
        Intent receivedIntent = getIntent();
        mPositionNumber = receivedIntent.getIntExtra(
                POSITION_NUMBER, mPositionNumber = mData.getLists().size() - 1);

        //Get reference variables to the xml views/view groups
        mRecyclerView = (RecyclerView) findViewById(R.id.items_list);
        mListName = (TextView) findViewById(R.id.list_name);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.list_floating_action_button);

        //Sync the TextView text with the list's name from the data
        mListName.setText(mData.getLists().get(mPositionNumber).getName());

        //Set up methods found below
        setFloatingActionButtonClickListener();
        addOrRemoveSplashText();

        //Set up layout manager and recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(ToDoListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new ListScreenRecyclerViewAdapter(mPositionNumber));



    }
    //When clicked, the floating action button creates an alert dialog
    public void setFloatingActionButtonClickListener() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = LayoutInflater.from(view.getContext());
                View dialogView = (inflater.inflate(R.layout.add_list_item_dialog, null));
                dialogBuilder.setView(dialogView);
                final EditText itemName = (EditText) dialogView.findViewById(R.id.new_todo);
                itemName.requestFocus();
                final EditText itemDescription = (EditText) dialogView.findViewById(R.id.details);
                final RadioButton lowPriority = (RadioButton) dialogView.findViewById(R.id.low_priority);
                final RadioButton mediumPriority = (RadioButton) dialogView.findViewById(R.id.medium_priority);
                final RadioButton highPriority = (RadioButton) dialogView.findViewById(R.id.high_priority);

                setRadioButtonClickListeners(lowPriority, mediumPriority, highPriority);


                dialogBuilder.setPositiveButton("okay", null);
                dialogBuilder.setNegativeButton("cancel", null);


                final AlertDialog dialog = dialogBuilder.create();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

                //This allows to me dismiss the dialog box manually
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        dialog.getButton(Dialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                if (itemName.getText().toString().equals("")) {
                                    itemName.setError("Name cannot be blank");
                                } else {
                                    if (itemDescription.getText().toString().equals("")) {
                                        mData.getLists().get(mPositionNumber).getItems().add(
                                                new ToDo(itemName.getText().toString(), ""));
                                        mRecyclerView.getAdapter().notifyItemChanged(
                                                mData.getLists().get(mPositionNumber).getItems().size() - 1);
                                    } else {
                                        mData.getLists().get(mPositionNumber).getItems().add(
                                                new ToDo(itemName.getText().toString(),
                                                        itemDescription.getText().toString())
                                        );
                                        mRecyclerView.getAdapter().notifyItemChanged(
                                                mData.getLists().get(mPositionNumber).getItems().size() - 1);
                                    }
                                    int priority;
                                    if (lowPriority.isChecked()) {
                                        priority = 0;
                                    } else if (mediumPriority.isChecked()) {
                                        priority = 1;
                                    } else if (highPriority.isChecked()) {
                                        priority = 2;
                                    } else {
                                        priority = 0;
                                    }
                                    ToDo addedToDo = mData.getLists().get(mPositionNumber).getItems().get(
                                            mData.getLists().get(mPositionNumber).getItems().size() - 1);
                                    switch (priority) {
                                        case 0:
                                            addedToDo.mPriority = 0;
                                            mRecyclerView.getAdapter().notifyItemChanged(mPositionNumber);
                                            break;
                                        case 1:
                                            addedToDo.mPriority = 1;
                                            mRecyclerView.getAdapter().notifyItemChanged(mPositionNumber);
                                            break;
                                        case 2:
                                            addedToDo.mPriority = 2;
                                            mRecyclerView.getAdapter().notifyItemChanged(mPositionNumber);
                                            break;
                                    }
                                    addOrRemoveSplashText();
                                    dialog.dismiss();
                                }
                            }
                        });

                    }

                });

                dialog.show();
            }
        });
    }

    public void setRadioButtonClickListeners(final RadioButton low, final RadioButton medium, final RadioButton high) {
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(true);
                medium.setChecked(false);
                high.setChecked(false);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(false);
                medium.setChecked(true);
                high.setChecked(false);
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(false);
                medium.setChecked(false);
                high.setChecked(true);
            }
        });
    }


    //When returning to the activity, evaluate the need for the splash text
    @Override
    public void onPostResume() {
        addOrRemoveSplashText();
        super.onPostResume();
    }

    //When the list is empty, show splash text. Else, hide it.
    public void addOrRemoveSplashText() {
        mSplashText = (TextView)findViewById(R.id.list_splash);
        if (mData.getLists().get(mPositionNumber).getItems().isEmpty()) {
            mSplashText.setVisibility(View.VISIBLE);
        } else {
            mSplashText.setVisibility(View.INVISIBLE);
        }
    }
}


