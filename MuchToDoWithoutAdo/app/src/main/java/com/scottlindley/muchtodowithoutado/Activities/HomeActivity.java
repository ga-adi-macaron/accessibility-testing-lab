package com.scottlindley.muchtodowithoutado.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoList;
import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoListCollection;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.HomeRecyclerViewAdapter;


public class HomeActivity extends AppCompatActivity {
    private TextView mSplashText;
    private FloatingActionButton mFloatingActionButton;
    private RecyclerView mRecyclerView;
    public static ToDoListCollection mData;
    private SharedPreferences mSavedData;
    public static final String PREFERENCES = "preferences";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Make instance of singleton
        mData = ToDoListCollection.getInstance();


        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.home_floating_action_button);


        initializeSplashText();

        //set XML references
        mRecyclerView = (RecyclerView)findViewById(R.id.home_recycler);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.home_floating_action_button);

        //Set up layout manager and recycler view
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new HomeRecyclerViewAdapter(HomeActivity.this));


        setClickListeners();

    }

    public void setClickListeners(){
        //Floating action button
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //Create a dialog box to enter in new list name
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = LayoutInflater.from(view.getContext());
                View dialogView = (inflater.inflate(R.layout.add_list_dialog_box, null));
                dialogBuilder.setView(dialogView);
                //reference to XML EditText
                final EditText newListName = (EditText)dialogView.findViewById(R.id.new_list_name);

                //Set positive button click listener
                dialogBuilder.setPositiveButton("okay", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Prevent blank list names
                        if(newListName.getText().toString().equals("")){
                            Log.d("tag", "onClick: BLANK NAME");
                            newListName.setError("Please give you list a name!");
                            Toast.makeText(HomeActivity.this, "List name cannot be blank", Toast.LENGTH_SHORT).show();
                        }else{
                            //Start activity and add a new ToDoList to the data with the entered name
                            mData.getLists().add(new ToDoList(newListName.getText().toString()));
                            mRecyclerView.getAdapter().notifyItemChanged(mData.getLists().size()-1);
                            Intent intent = new Intent(HomeActivity.this, ToDoListActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            Log.d("IN DIALOG", "onClick: "+ mData.getLists().size());
                            view.getContext().startActivity(intent);
                        }
                    }
                });
                //Set negative click listener
                dialogBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                final AlertDialog dialog = dialogBuilder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(newListName.getText().toString().equals("")){
                                    Log.d("tag", "onClick: BLANK NAME");
                                    newListName.setError("Please give you list a name!");
                                    Toast.makeText(HomeActivity.this, "List name cannot be blank", Toast.LENGTH_SHORT).show();
                                }else {
                                    //Start activity and add a new ToDoList to the data with the entered name
                                    dialog.dismiss();
                                    mData.getLists().add(new ToDoList(newListName.getText().toString()));
                                    mRecyclerView.getAdapter().notifyItemChanged(mData.getLists().size() - 1);
                                    Intent intent = new Intent(HomeActivity.this, ToDoListActivity.class);
        //                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    Log.d("IN DIALOG", "onClick: " + mData.getLists().size());
                                    view.getContext().startActivity(intent);
                                }
                            }
                        });

                    }
                });
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                dialog.show();
            }
        });



    }

    public void initializeSplashText(){
        mSplashText = (TextView)findViewById(R.id.home_splash);
        if(mData.getLists().isEmpty()){
            mSplashText.setVisibility(View.VISIBLE);

            mFloatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(225,253,240)));
            mFloatingActionButton.setImageResource(R.drawable.ic_add_black_24dp);

        }else{
            mSplashText.setVisibility(View.INVISIBLE);

            mFloatingActionButton.setBackgroundTintList(
                    ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
            mFloatingActionButton.setImageResource(R.drawable.ic_add_white_24dp);
        }
    }

    //This determines whether or not the splash text is necessary
    @Override
    protected void onPostResume() {
        initializeSplashText();
        super.onPostResume();
    }



}
