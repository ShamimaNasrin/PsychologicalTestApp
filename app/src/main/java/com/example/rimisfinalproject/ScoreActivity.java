package com.example.rimisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import Database.Patient_info;

public class ScoreActivity extends AppCompatActivity {
    Button DocListBTN,Depdetailsbtn;
    TextView SeverityLevelTV,PreviousScoreTV;
    ImageView saveScoreIV,homeScoreIV;
    LinearLayout doclistlayout;
    Patient_info patientInfoDB;
    String get_phone = MainActivity.phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        DocListBTN =(Button)findViewById(R.id.DocListbtnID);
        Depdetailsbtn =(Button)findViewById(R.id.Dep_detailsbtnID);
        SeverityLevelTV =(TextView) findViewById(R.id.SeverityLevelTVID);
        PreviousScoreTV = (TextView)findViewById(R.id.ScoreShowTVID);
        saveScoreIV = (ImageView) findViewById(R.id.saveScorIVID);
        homeScoreIV = (ImageView) findViewById(R.id.ScoreHomeIVID);
        doclistlayout = (LinearLayout) findViewById(R.id.DocListlayoutID);

        patientInfoDB = new Patient_info(this);
        SQLiteDatabase sqLiteDatabase = patientInfoDB.getWritableDatabase();
        PreviousScoreTV.setText(MainActivity.score);


        String get_severity = getIntent().getStringExtra("SeverityLevel");
        SeverityLevelTV.setText(get_severity);
        boolean get_mildvalue = getIntent().getBooleanExtra("Mildvalue",false);
        if (get_mildvalue==true){
            doclistlayout.setVisibility(View.GONE);

        }

        homeScoreIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


        saveScoreIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Boolean result = patientInfoDB.updateScoreMethod(get_phone,get_severity);
                    if (result==true){
                        Toast.makeText(ScoreActivity.this, "Record updated", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(ScoreActivity.this, "Score Update failed", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Toast.makeText(ScoreActivity.this, "Please enter the correct phone number", Toast.LENGTH_SHORT).show();
                }

            }
        });


        DocListBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, DocListActivity.class);
                startActivity(intent);
                //finish();

            }
        });


        Depdetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreActivity.this, DepressionDetailsActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}