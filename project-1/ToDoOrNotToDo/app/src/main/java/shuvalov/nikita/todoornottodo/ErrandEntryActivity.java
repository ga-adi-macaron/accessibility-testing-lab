package shuvalov.nikita.todoornottodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ErrandEntryActivity extends AppCompatActivity {
    private EditText userInputView;
    private Button getUI, cancelButt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errand_entry);

        userInputView =(EditText) findViewById(R.id.uiText);
        getUI = (Button) findViewById(R.id.submitErrandButton);
        cancelButt =(Button) findViewById(R.id.cancelButt);

        final Intent userIntent = new Intent();
        getUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userIntent.putExtra(String.valueOf(R.string.user_note),userInputView.getText().toString());
                setResult(RESULT_OK,userIntent);
                finish();
            }
        });
        cancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED,userIntent);
                finish();
            }
        });
    }
}
