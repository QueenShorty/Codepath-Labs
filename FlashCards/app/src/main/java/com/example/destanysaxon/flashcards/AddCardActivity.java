package com.example.destanysaxon.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        //Returns us to main Activity
        findViewById(R.id.CancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddCardActivity.this, MainActivity.class));
            }
        });

        //passes data to main activity
        findViewById(R.id.SaveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int REQUEST_CODE = 20;

                // 1. create an intent pass class name or intnet action name
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);

                // 2. put key/value data
                //get values from user input
                EditText question = findViewById(R.id.inputQuestion);
                String questionValue = question.getText().toString();
                EditText answer = findViewById(R.id.inputAnswer);
                String answerValue = answer.getText().toString();
                //adds to intent
                intent.putExtra("question", questionValue);
                intent.putExtra("answer", answerValue);

                // 3. start the activity
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

}
