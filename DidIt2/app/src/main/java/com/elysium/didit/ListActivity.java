package com.elysium.didit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class ListActivity extends AppCompatActivity {

    private EditText mEditTitle, mEditDescription;
    private Button mSave, mClear;
    private RecyclerView mListRView;
    private List<ToDoItems> mToDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do_list);


                    mListRView = (RecyclerView) findViewById(R.id.ListRview);

                    LinearLayoutManager layoutManager = new LinearLayoutManager(mListRView.getContext());
                    mListRView.setLayoutManager(layoutManager);

                    mEditTitle = (EditText) findViewById(R.id.list_name);
                    mEditDescription = (EditText) findViewById(R.id.description);

                    mSave = (Button) findViewById(R.id.save_button);
                    mClear = (Button) findViewById(R.id.clear_button);

                    Intent intent = getIntent();

                    int listPosition = intent.getIntExtra("ListPosition", -1);
                    mToDoList = Sublist.getInstance().getToDoLists().get(listPosition).getToDoItems();


                    mEditTitle.setHint("Item Title");
                    mEditTitle.setText(intent.getStringExtra("Item Title"));

                    mEditDescription.setHint("Item Description");
                    mEditDescription.setText(intent.getStringExtra("Item Description"));

                    mSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mEditTitle.getText().length() < 1) {
                                mEditTitle.setError("Title Can't Be Empty");
                            } else {
                                mToDoList.add(new ToDoItems(mEditTitle.getText().toString(),
                                        mEditDescription.getText().toString()));
                                mListRView.getAdapter().notifyItemInserted(mToDoList.size() - 1);
                            }
                            mEditTitle.setText("");
                            mEditDescription.setText("");
                        }
                    });

                    mClear.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mEditTitle.setText("");
                            mEditDescription.setText("");
                        }
                    });

                    mListRView.setAdapter(new ListAdapter(mToDoList));
                }
            }
