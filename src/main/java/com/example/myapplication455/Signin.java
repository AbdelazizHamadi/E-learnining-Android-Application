package com.example.myapplication455;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    private UsersDataSource datasource;

    EditText logUsername;
    EditText logPassword;

    TextView lLogin;
    TextView lSingup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        logUsername = (EditText) findViewById(R.id.logUser);
        logPassword = (EditText) findViewById(R.id.logPwd);
        lLogin = (TextView) findViewById(R.id.logLogin);
        lSingup = (TextView) findViewById(R.id.logSingup);

        lLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datasource = new UsersDataSource(Signin.this);
                datasource.readdb();

                String user = logUsername.getText().toString().trim();
                String pwd = logPassword.getText().toString().trim();
                Boolean res = datasource.checkUserLogin(user,pwd);

                if(res == true){
                    Toast.makeText(Signin.this,"Successfully logged in !! ", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(Signin.this, MainActivity.class);
                    startActivity(mainIntent);

                }
                else {
                    Toast.makeText(Signin.this,"Wrong username or password try again ! ", Toast.LENGTH_SHORT).show();
                }

                datasource.close();

            }
        });

        lSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singupIntent = new Intent(Signin.this,Signup.class);
                startActivity(singupIntent);
            }
        });
    }
}
