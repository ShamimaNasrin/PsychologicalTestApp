package com.example.rimisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DocLoginActivity extends AppCompatActivity {
    EditText DocUsernameET,DocPasswordET;
    Button Docloginbtn;
    ImageView DocbackIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);

        DocUsernameET =(EditText)findViewById(R.id.DocusernameET);
        DocPasswordET =(EditText)findViewById(R.id.DocpasswordET);
        Docloginbtn =(Button) findViewById(R.id.DocloginButtonID);
        DocbackIV =(ImageView)findViewById(R.id.DocbackIVID);

        Docloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DocUsernameET.getText().toString().equals("") && DocPasswordET.getText().toString().equals("")){
                    Toast.makeText(DocLoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }else {
                    if(DocUsernameET.getText().toString().equals("doctora") && DocPasswordET.getText().toString().equals("1234")){
                        Toast.makeText(DocLoginActivity.this, "successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DocLoginActivity.this,DoctorAPage.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(DocLoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }

                    if(DocUsernameET.getText().toString().equals("doctorb") && DocPasswordET.getText().toString().equals("1234")){
                        Toast.makeText(DocLoginActivity.this, "successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DocLoginActivity.this,DoctorB_Page.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(DocLoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }

                    if(DocUsernameET.getText().toString().equals("doctorc") && DocPasswordET.getText().toString().equals("1234")){
                        Toast.makeText(DocLoginActivity.this, "successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DocLoginActivity.this,DoctorC_Page.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(DocLoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        DocbackIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DocLoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}