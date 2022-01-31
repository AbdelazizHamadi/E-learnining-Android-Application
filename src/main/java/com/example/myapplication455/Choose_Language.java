package com.example.myapplication455;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

public class Choose_Language extends AppCompatActivity {
    ImageView IMG;
    ImageView nextRe;
    int slcJava = 0,slcC=0,slcPhp=0 ;

    private UsersDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__language);
        IMG=(ImageView)findViewById(R.id.imageView2);


        final String user;
        final String pwd;
        final String mail;
        final String phone;

        user = getIntent().getStringExtra("user");
        pwd = getIntent().getStringExtra("pwd");
        mail = getIntent().getStringExtra("mail");
        phone = getIntent().getStringExtra("phone");

        nextRe = (ImageView) findViewById(R.id.nextRe);

        nextRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datasource = new UsersDataSource(Choose_Language.this);
                datasource.open();

                long insId=0;
                Userdb userl = null;
                userl = datasource.createUser(user,pwd,mail,phone,1,1,1);
                    Toast.makeText(Choose_Language.this,"Added !",Toast.LENGTH_SHORT).show();
                    Intent lvlAct = new Intent(Choose_Language.this, LevelTestLanguage_C.class);
                    startActivity(lvlAct);
            }
        });



    }




    public void Photographe (View view) {

        Intent myIntent = new Intent(getBaseContext(),   Signin.class);
        startActivity(myIntent);

        IMG.setColorFilter(5);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void changepic(View view) {

        if (slcJava==0)
        {

            IMG.setImageResource(R.drawable.javaselected);
            slcJava=1;
        }else
        {
            IMG.setImageResource(R.drawable.javaselect2);
            slcJava=0;
        }

    }
}
