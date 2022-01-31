package com.example.myapplication455;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Choose_testOrCours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test_or_cours);
    }

    public void Gotoclassess(View view) {

        Intent myIntent = new Intent(getBaseContext(),   classes.class);
        startActivity(myIntent);
    }

    public void GoToTests(View view) {

        Intent myIntent = new Intent(getBaseContext(),   Levels.class);
        startActivity(myIntent);

    }

}
