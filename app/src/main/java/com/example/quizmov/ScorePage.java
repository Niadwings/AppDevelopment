package com.example.quizmov;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.quizmov.StoreScore;

public class ScorePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);
        TextView tv = findViewById(R.id.score);
        StoreScore ss = new StoreScore();
        tv.setText(Integer.toString(StoreScore.score));
    }
}