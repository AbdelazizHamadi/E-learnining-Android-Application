package com.example.myapplication455;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

public class ModifierProfile extends AppCompatActivity {

    EditText Edit1;
    EditText Edit2;
    EditText Edit3;
    EditText Edit4;
    ImageView IMG1;
    ImageView IMG2;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this,R.style.DialogeTheme)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Leaving")
                .setMessage("Are you sure you want to leave ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profile);
        Edit1=(EditText)findViewById(R.id.mail);
        Edit2=(EditText)findViewById(R.id.user);
        Edit3=(EditText)findViewById(R.id.passwrd);
        Edit4=(EditText)findViewById(R.id.mobphone);
        IMG1 = (ImageView)findViewById(R.id.imageView9);
        IMG2 = (ImageView)findViewById(R.id.imageView11);


        IMG2.setColorFilter(Color.parseColor("#E4E4E4"));
        IMG2.setEnabled(false);
        Edit1.setEnabled(false);
        Edit1.setText("aziz@seven.com");
        Edit1.setTextColor(Color.parseColor("#E4E4E4"));
        Edit2.setEnabled(false);
        Edit2.setText("Aziz");
        Edit2.setTextColor(Color.parseColor("#E4E4E4"));
        Edit3.setEnabled(false);
        Edit3.setText("12345");
        Edit3.setTextColor(Color.parseColor("#E4E4E4"));
        Edit4.setEnabled(false);
        Edit4.setText("0696663837");
        Edit4.setTextColor(Color.parseColor("#E4E4E4"));
    }


    public void modify(View view) {

        IMG1.setImageResource(R.drawable.unlock);
        Edit1.setTextColor(Color.parseColor("#FFFFFF"));
        Edit2.setTextColor(Color.parseColor("#FFFFFF"));
        Edit3.setTextColor(Color.parseColor("#FFFFFF"));
        Edit4.setTextColor(Color.parseColor("#FFFFFF"));
        Edit1.setEnabled(true);
        Edit2.setEnabled(true);
        Edit3.setEnabled(true);
        Edit3.setTransformationMethod(null);
        Edit4.setEnabled(true);
        IMG2.setEnabled(true);
        IMG2.setColorFilter(Color.parseColor("#A33030"));




    }

    public void Saving(View view) {



    }
}
