package com.example.quizmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizmov.StoreScore;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        RadioGroup Q1ans = findViewById(R.id.groupanswers);
        Button answerQ1 = findViewById(R.id.submit1);
        String receivedData = getIntent().getStringExtra("name");
        Toast.makeText(Question1.this, "Hello " + receivedData, Toast.LENGTH_SHORT).show();

        answerQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonID = Q1ans.getCheckedRadioButtonId();
                if (selectedRadioButtonID != -1) {
                    RadioButton selectedRb = findViewById(selectedRadioButtonID);
//                    if (Integer.parseInt(selectedRb.getText().toString()) == 3) { // when the answer is equals to integer
                    if (selectedRb.getText().toString().equals("Venus")) { // when the answer is string
                        StoreScore.score += 2;
                        Toast.makeText(Question1.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Question1.this, Question2.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Question1.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Question1.this, "Selected " + selectedRb.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question1.this, "No choices selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onclick(View v) {
        Intent queue = new Intent(this, Question1.class);
        Toast.makeText(this, "Question 2 started", Toast.LENGTH_SHORT).show();
        queue.putExtra("name", "Player");
        startActivity(queue);
    }
}
