package com.example.rimisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.Patient_info;

public class MainActivity extends AppCompatActivity {
    EditText LUsernameET,LPasswordET;
    Button loginbtn;
    TextView signupTV,DocLoginTV;
    Patient_info patientInfoDB;

    public static String phone;
    public static String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LUsernameET =(EditText)findViewById(R.id.usernameET);
        LPasswordET =(EditText)findViewById(R.id.passwordET);
        loginbtn =(Button) findViewById(R.id.loginButtonID);
        signupTV =(TextView)findViewById(R.id.signUpTVID);
        DocLoginTV =(TextView)findViewById(R.id.DocLoginTVID);

        patientInfoDB = new Patient_info(this);
        SQLiteDatabase sqLiteDatabase = patientInfoDB.getWritableDatabase();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String given_username = LUsernameET.getText().toString();
                String given_password = LPasswordET.getText().toString();
                Boolean result = patientInfoDB.LoginMethod(given_username,given_password);

                if (result==true){
                    String p = patientInfoDB.fetchPhone(given_username,given_password);
                    MainActivity.phone = p;
                    String s = patientInfoDB.fetchScore(given_username,given_password);
                    MainActivity.score = s;
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();


                }else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        DocLoginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DocLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}