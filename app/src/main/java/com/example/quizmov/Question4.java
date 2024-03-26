package com.example.quizmov;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quizmov.StoreScore;

public class Question4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        RadioGroup Q4ans = findViewById(R.id.groupanswers4);
        Button answerQ4 = findViewById(R.id.submit4);
        String receivedData = getIntent().getStringExtra("name");
        Toast.makeText(Question4.this, "Hello " + receivedData, Toast.LENGTH_SHORT).show();

        answerQ4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonID = Q4ans.getCheckedRadioButtonId();
                if (selectedRadioButtonID != -1) {
                    RadioButton selectedRb = findViewById(selectedRadioButtonID);
//                    if (Integer.parseInt(selectedRb.getText().toString()) == 3) { // when the answer is equals to integer
                    if (selectedRb.getText().toString().equals("Marie Curie")) { // when the answer is string
                        StoreScore.score += 2;
                        Toast.makeText(Question4.this, "Correct Answer!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Question4.this, Question5.class);

                        startActivity(intent);

                    } else {
                        Toast.makeText(Question4.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(Question4.this, "Selected " + selectedRb.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Question4.this, "No choices selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void clicker(View v) {
        Intent queue = new Intent(this, Question1.class);
        Toast.makeText(this, "Question 5 started", Toast.LENGTH_SHORT).show();
        queue.putExtra("name", "Player");
        startActivity(queue);

    }
}