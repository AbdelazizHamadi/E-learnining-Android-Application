package com.example.myapplication455;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText sinMail;
    EditText sinUsername;
    EditText sinPassword;
    EditText sinCnPassword;
    EditText sinPhone;
    //DatabaseHelper db;
    TextView sSingup;

    TextView sLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //db = new DatabaseHelper(this);

        sinMail = (EditText) findViewById(R.id.sinMain);
        sinUsername = (EditText) findViewById(R.id.sinUser);
        sinPassword = (EditText) findViewById(R.id.sinPwd);
        sinCnPassword = (EditText) findViewById(R.id.sinCnPwd);
        sinPhone = (EditText) findViewById(R.id.sinPhone);

        sSingup = (TextView) findViewById(R.id.sSingup);

        sLogin = (TextView) findViewById(R.id.sLogin);


        sSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = sinUsername.getText().toString().trim();
                String pwd = sinPassword.getText().toString().trim();
                String cnpwd = sinCnPassword.getText().toString().trim();
                String mail = sinMail.getText().toString().trim();
                String phone = sinPhone.getText().toString().trim();
                if (pwd.equals(cnpwd)){
                    //long val = db.addUser(user, pwd, mail, phone, "aaa");

                        Toast.makeText(Signup.this, "Registred !",Toast.LENGTH_SHORT).show();
                        Intent chooselng = new Intent(Signup.this, Choose_Language.class);
                        chooselng.putExtra("user",user);
                        chooselng.putExtra("pwd",pwd);
                        chooselng.putExtra("mail",mail);
                        chooselng.putExtra("phone",phone);
                        startActivity(chooselng);

                }
                else {
                    Toast.makeText(Signup.this, "Passwords are not matched! try again",Toast.LENGTH_SHORT).show();

                }
            }
        });

        sLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Signup.this, Signin.class);
                startActivity(loginIntent);
            }
        });
    }
}
