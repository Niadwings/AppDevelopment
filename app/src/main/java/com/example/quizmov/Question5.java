package com.example.quizmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        RadioGroup Q5ans = findViewById(R.id.groupanswers5);
        Button answerQ5 = findViewById(R.id.submit5);
        String receivedData = getIntent().getStringExtra("name");
        Toast.makeText(Question5.this, "Hello " + receivedData, Toast.LENGTH_SHORT).show();

        answerQ5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonID = Q5ans.getCheckedRadioButtonId();
                if (selectedRadioButtonID != -1) {
                    RadioButton selectedRb = findViewById(selectedRadioButtonID);
                    if (Integer.parseInt(selectedRb.getText().toString()) == 6) { // when the answer is equals to integer
                        com.example.quizmov.StoreScore.score += 2;
                        Toast.makeText(Question5.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Question5.this, ScorePage.class);

                        startActivity(intent);

                    } else {
                        Toast.makeText(Question5.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Question5.this, "Selected " + selectedRb.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question5.this, "No choices selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void clicker(View v) {
        Intent queue = new Intent(this, Question1.class);
        Toast.makeText(this, "Last Round", Toast.LENGTH_SHORT).show();
        queue.putExtra("name", "Player");
        startActivity(queue);

    }
}