package com.davescar.project1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.davescar.project1.chore.Chore;
import com.davescar.project1.chore.ChoreAdapter;
import com.davescar.project1.list_chores.ChoreList;

import java.util.List;

public class ListOfChoresActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Chore> mChoreList;
    EditText mChore_Name;
    EditText mChore_Description;
    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_chores);

        mChore_Name = (EditText) findViewById(R.id.chore_name);
        mChore_Description = (EditText) findViewById(R.id.chore_description);

        int position = getIntent().getIntExtra("positionKey",-1);
        if (position== -1) {
            finish();
        }

        final ChoreList choreList1 = ListOfTheLists.getInstance().getmListOfTheLists().get(position);

        final ChoreAdapter choreAdapter = new ChoreAdapter(choreList1.getChoreList());
        mRecyclerView = (RecyclerView) findViewById(R.id.RView_ListOfChores);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(choreAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (mChore_Name.getText().toString().isEmpty()) {
                    mChore_Name.setError("Please enter a Chore Name");

                } else {

                    String title = mChore_Name.getText().toString();
                    String description = mChore_Description.getText().toString();

                    Chore add_chore = new Chore(title, description, false);
                    choreList1.getChoreList().add(add_chore);
                    choreAdapter.notifyDataSetChanged();

                    mChore_Name.setText("");
                    mChore_Description.setText("");
                }
            }
        });
    }
}


