package com.example.myapplication455;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView Profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Profil=(ImageView)findViewById(R.id.profil1);
    }


  public void Profile(View view) {

        Intent myIntent = new Intent(getBaseContext(),   ModifierProfile.class);
        startActivity(myIntent);
    }

    public void choose(View view) {

        Intent myIntent = new Intent(getBaseContext(),   Choose_testOrCours.class);
        startActivity(myIntent);

    }

    public void calendar(View view) {


        Intent myIntent = new Intent(getBaseContext(),   CoursViewer.class);
        startActivity(myIntent);

    }
}
