package com.example.rimisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import Database.Patient_info;

public class SignupActivity extends AppCompatActivity {
    EditText nameET,ageET,phoneET,usernameET,passwordET,confirmpassET;
    Button submitbtn;
    RadioGroup RBgroup;
    RadioButton Genderbtn;
    ImageView backIV;
    int value;
    Patient_info patientInfoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameET =(EditText)findViewById(R.id.NameETID);
        RBgroup = (RadioGroup) findViewById(R.id.RBgroupID);

        ageET =(EditText)findViewById(R.id.AgeETID);
        usernameET =(EditText)findViewById(R.id.UsernameETID);
        passwordET =(EditText)findViewById(R.id.PasswordETID);
        confirmpassET =(EditText)findViewById(R.id.ConfirmPassETID);
        submitbtn =(Button) findViewById(R.id.SubmitbtnID);
        phoneET =(EditText)findViewById(R.id.PhoneETID);
        backIV =(ImageView)findViewById(R.id.backIVID);

        patientInfoDB = new Patient_info(this);
        SQLiteDatabase sqLiteDatabase = patientInfoDB.getWritableDatabase();


        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = nameET.getText().toString().trim();
                String Age = ageET.getText().toString().trim();
                String Phone = phoneET.getText().toString().trim();
                String UserName = usernameET.getText().toString().trim();
                String Password = passwordET.getText().toString().trim();
                String ConfirmPassword = confirmpassET.getText().toString().trim();//edit

                value=RBgroup.getCheckedRadioButtonId();
                Genderbtn=(RadioButton)findViewById(value);
                String Gender = Genderbtn.getText().toString();

                Boolean get_phone = patientInfoDB.CheckPhoneMethod(Phone);

                if (Name.equals("") || Age.equals("") || Gender.equals("") || Phone.equals("") || UserName.equals("") || Password.equals("")){
                    Toast.makeText(SignupActivity.this,"Empty Field",Toast.LENGTH_SHORT).show();
                } else if (Password.length()<8){
                    Toast.makeText(SignupActivity.this, "Password must be more than 8 character", Toast.LENGTH_SHORT).show();
                }
                else if (get_phone == true){
                    Toast.makeText(SignupActivity.this, "Phone number already exist", Toast.LENGTH_SHORT).show();
                }
                else if (!Password.equals(ConfirmPassword)){
                    Toast.makeText(SignupActivity.this, "Wrong password", Toast.LENGTH_SHORT).show();
                }
                else {

                    long rowID = patientInfoDB.InsertSignupData(Name,Age,Gender,Phone,UserName,Password);
                    if (rowID == -1){
                        Toast.makeText(SignupActivity.this,"Unsuccessful",Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(SignupActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }

            }
        });
    }
}