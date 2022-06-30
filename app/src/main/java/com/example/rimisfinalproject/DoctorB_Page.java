package com.example.rimisfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Database.DocADB;
import Database.DocB_db;

public class DoctorB_Page extends AppCompatActivity {
    ListView listView_B;
    DocB_db docB_db;
    Button deleteBTN;
    AlertDialog alertDialog;
    ImageView deleteIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_bpage);

        listView_B = (ListView) findViewById(R.id.DocBLVID);
        //deleteBTN = (Button) findViewById(R.id.BDeletebtnID);
        deleteIMG = (ImageView) findViewById(R.id.BDeletebtnID);

        docB_db = new DocB_db(this);
        SQLiteDatabase sqLiteDatabase = docB_db.getWritableDatabase();

        loadData();


        deleteIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.delete_patient,null);
                alertDialog = new AlertDialog.Builder(DoctorB_Page.this).setView(view).create();
                alertDialog.show();

                EditText patientNumber = (EditText) view.findViewById(R.id.delete_id_et);
                Button DeleteBtnID = (Button) view.findViewById(R.id.delete_btn_id);

                DeleteBtnID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int del = docB_db.deleteMethod(patientNumber.getText().toString().trim());
                        if(del>0){
                            Toast.makeText(DoctorB_Page.this, "Delete successful", Toast.LENGTH_SHORT).show();
                            loadData();
                            alertDialog.cancel();
                        }else {
                            Toast.makeText(DoctorB_Page.this, "Delete failed", Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();
                        }
                    }
                });
            }
        });
    }

    private void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = docB_db.showAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data is found", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                listData.add(" Patient Number:  "+cursor.getString(0) +"\t\t Name:  "+cursor.getString(1) +"\t\t\t  Phone:  "+cursor.getString(2) );
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.doctor_list_sample,R.id.aTVid,listData);
        listView_B.setAdapter(adapter);
    }

}