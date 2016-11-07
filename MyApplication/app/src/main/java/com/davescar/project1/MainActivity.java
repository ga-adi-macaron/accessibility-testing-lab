package com.davescar.project1;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.davescar.project1.list_chores.ChoreList;
import com.davescar.project1.list_chores.ListsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<ChoreList> mListOfLists;
    EditText mAddList;
    FloatingActionButton mFabMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListOfLists = ListOfTheLists.getInstance().getmListOfTheLists();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        final ListsAdapter listsAdapter = new ListsAdapter(mListOfLists);

        mRecyclerView.setAdapter(listsAdapter);

        mAddList = (EditText) findViewById(R.id.addList);
        mFabMain = (FloatingActionButton) findViewById(R.id.fabMain);

        mFabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mAddList.getText().toString().isEmpty()) {
                    mAddList.setError("Please enter some text");

                } else {

                    String userInput = mAddList.getText().toString();
                    ChoreList choreList = new ChoreList(userInput);
                    ListOfTheLists.getInstance().makeNewList(choreList);

                    listsAdapter.notifyDataSetChanged();

                    mAddList.setText("");
                }

            }
        });




    }
}