package com.example.myapplication455;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView Score = (TextView)findViewById(R.id.Score);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        String Final_Score= intent.getStringExtra("Score");
        Score.setText(Final_Score);

    }
}
