package com.example.quizmov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quizmov.Question1;
import com.example.quizmov.StoreScore;

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        RadioGroup Q3ans = findViewById(R.id.groupanswers3);
        Button answerQ3 = findViewById(R.id.submit3);
        String receivedData = getIntent().getStringExtra("name");
        Toast.makeText(Question3.this, "Hello " + receivedData, Toast.LENGTH_SHORT).show();

        answerQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonID = Q3ans.getCheckedRadioButtonId();
                if (selectedRadioButtonID != -1) {
                    RadioButton selectedRb = findViewById(selectedRadioButtonID);
//                    if (Integer.parseInt(selectedRb.getText().toString()) == 3) { // when the answer is equals to integer
                    if (selectedRb.getText().toString().equals("All of the above")) { // when the answer is string
                        StoreScore.score += 2;
                        Toast.makeText(Question3.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Question3.this, Question4.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Question3.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Question3.this, "Selected " + selectedRb.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question3.this, "No choices selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void clicker(View v) {
        Intent queue = new Intent(this, Question1.class);
        Toast.makeText(this, "Question 4 started", Toast.LENGTH_SHORT).show();
        queue.putExtra("name", "Player");
        startActivity(queue);

    }
}