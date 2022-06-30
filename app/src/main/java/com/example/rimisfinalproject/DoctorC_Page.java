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

import Database.DocB_db;
import Database.DocC_db;

public class DoctorC_Page extends AppCompatActivity {
    ListView listView_C;
    DocC_db docC_db;
    Button deleteBTN;
    AlertDialog alertDialog;
    ImageView deleteIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_cpage);

        //deleteBTN = (Button) findViewById(R.id.CDeletebtnID);
        deleteIMG = (ImageView) findViewById(R.id.CDeletebtnID);
        listView_C = (ListView) findViewById(R.id.DocCLVID);

        docC_db = new DocC_db(this);
        SQLiteDatabase sqLiteDatabase = docC_db.getWritableDatabase();

        loadData();

        deleteIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.delete_patient,null);
                alertDialog = new AlertDialog.Builder(DoctorC_Page.this).setView(view).create();
                alertDialog.show();

                EditText patientNumber = (EditText) view.findViewById(R.id.delete_id_et);
                Button DeleteBtnID = (Button) view.findViewById(R.id.delete_btn_id);

                DeleteBtnID.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int del = docC_db.deleteMethod(patientNumber.getText().toString().trim());
                        if(del>0){
                            Toast.makeText(DoctorC_Page.this, "Delete successful", Toast.LENGTH_SHORT).show();
                            loadData();
                            alertDialog.cancel();
                        }else {
                            Toast.makeText(DoctorC_Page.this, "Delete failed", Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();
                        }
                    }
                });
            }
        });


    }

    private void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = docC_db.showAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data is found", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                listData.add(" Patient Number:  "+cursor.getString(0) +" \t\t Name:  "+cursor.getString(1) +"\t\t\t  Phone:  "+cursor.getString(2) );
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.doctor_list_sample,R.id.aTVid,listData);
        listView_C.setAdapter(adapter);
    }

}