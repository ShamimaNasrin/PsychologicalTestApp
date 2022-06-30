package com.example.rimisfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import Database.DocADB;
import Database.DocB_db;
import Database.DocC_db;
import Database.Patient_info;

public class DocListActivity extends AppCompatActivity {
    ImageView homeDocIV;
    Button ACallBTN,BCallBTN,CCallBTN,AppointABTN,AppointBBTN,AppointCBTN;
    AlertDialog alertDialog;
    int y,m,d;
    DocADB docADB;
    DocB_db docB_db;
    DocC_db docC_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_list);
        Initialize();

        docADB = new DocADB(this);
        SQLiteDatabase sqLiteDatabase = docADB.getWritableDatabase();

        docB_db = new DocB_db(this);
        SQLiteDatabase sqLiteDatabaseTwo = docB_db.getWritableDatabase();

        docC_db = new DocC_db(this);
        SQLiteDatabase sqLiteDatabaseThree = docC_db.getWritableDatabase();


        homeDocIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DocListActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //Doctor A
        ACallBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String number = "0186555";

                if (number.isEmpty())
                {
                    Toast.makeText(DocListActivity.this, "empty number", Toast.LENGTH_SHORT).show();
                }else {
                    intent.setData(Uri.parse("tel:"+number));
                }

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(DocListActivity.this, "permission required", Toast.LENGTH_SHORT).show();
                    RequestPermission();
                }else {
                    startActivity(intent);
                }
            }
        });

        //Doctor B
        BCallBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String number = "0186555";

                if (number.isEmpty())
                {
                    Toast.makeText(DocListActivity.this, "empty number", Toast.LENGTH_SHORT).show();
                }else {
                    intent.setData(Uri.parse("tel:"+number));
                }

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(DocListActivity.this, "permission required", Toast.LENGTH_SHORT).show();
                    RequestPermission();
                }else {
                    startActivity(intent);
                }
            }
        });


        //Doctor C
        CCallBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String number = "0186555";

                if (number.isEmpty())
                {
                    Toast.makeText(DocListActivity.this, "empty number", Toast.LENGTH_SHORT).show();
                }else {
                    intent.setData(Uri.parse("tel:"+number));
                }

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(DocListActivity.this, "permission required", Toast.LENGTH_SHORT).show();
                    RequestPermission();
                }else {
                    startActivity(intent);
                }
            }
        });

        AppointABTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDoctorADialogue();
            }
        });

        AppointBBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDoctorBDialogue();
            }
        });


        AppointCBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDoctorCDialogue();
            }
        });




    }

    private void showDoctorCDialogue() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.doctor_a_ca,null);
        alertDialog = new AlertDialog.Builder(DocListActivity.this).setView(view).create();
        alertDialog.show();

        EditText patient_name = view.findViewById(R.id.PatientNameETID);
        EditText patient_phone = view.findViewById(R.id.PatientPhoneETID);
        TextView patient_date = view.findViewById(R.id.DocADateTVID);
        Button submitBTNa = view.findViewById(R.id.DocASubmitbtnId);
        Calendar c = Calendar.getInstance();


        patient_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DocListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m = month+1;
                        patient_date.setText(year+"/"+m+"/"+dayOfMonth);
                    }
                },y,m,d);
                datePickerDialog.show();
            }
        });
        submitBTNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = patient_name.getText().toString().trim();
                String phone = patient_phone.getText().toString().trim();
                if(name.equals("") && phone.equals("") && patient_date.getText().toString().equals("")){
                    Toast.makeText(DocListActivity.this, "You should input your details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Cursor checkDate = docC_db.checkAvailibility(patient_date.getText().toString().trim());
                    if(checkDate.getCount()<5){
                        long rowID = docC_db.InsertPatientData(name,phone,patient_date.getText().toString());
                        if (rowID == -1){
                            Toast.makeText(DocListActivity.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();

                        }else {
                            Toast.makeText(DocListActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();

                        }
                    }
                    else {
                        Toast.makeText(DocListActivity.this, "Seat fill up.Try another date", Toast.LENGTH_SHORT).show();

                    }



                }
            }
        });
    }

    private void showDoctorBDialogue() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.doctor_a_ca,null);
        alertDialog = new AlertDialog.Builder(DocListActivity.this).setView(view).create();
        alertDialog.show();

        EditText patient_name = view.findViewById(R.id.PatientNameETID);
        EditText patient_phone = view.findViewById(R.id.PatientPhoneETID);
        TextView patient_date = view.findViewById(R.id.DocADateTVID);
        Button submitBTNa = view.findViewById(R.id.DocASubmitbtnId);
        Calendar c = Calendar.getInstance();


        patient_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DocListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m = month+1;
                        patient_date.setText(year+"/"+m+"/"+dayOfMonth);
                    }
                },y,m,d);
                datePickerDialog.show();
            }
        });
        submitBTNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = patient_name.getText().toString().trim();
                String phone = patient_phone.getText().toString().trim();
                if(name.equals("") && phone.equals("") && patient_date.getText().toString().equals("")){
                    Toast.makeText(DocListActivity.this, "You should input your details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Cursor checkDate = docB_db.checkAvailibility(patient_date.getText().toString().trim());
                    if(checkDate.getCount()<5){
                        long rowID = docB_db.InsertPatientData(name,phone,patient_date.getText().toString());
                        if (rowID == -1){
                            Toast.makeText(DocListActivity.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();

                        }else {
                            Toast.makeText(DocListActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();

                        }
                    }
                    else {
                        Toast.makeText(DocListActivity.this, "Seat fill up.Try another date", Toast.LENGTH_SHORT).show();

                    }



                }
            }
        });

    }

    private void showDoctorADialogue() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.doctor_a_ca,null);
        alertDialog = new AlertDialog.Builder(DocListActivity.this).setView(view).create();
        alertDialog.show();

        EditText patient_name = view.findViewById(R.id.PatientNameETID);
        EditText patient_phone = view.findViewById(R.id.PatientPhoneETID);
        TextView patient_date = view.findViewById(R.id.DocADateTVID);
        Button submitBTNa = view.findViewById(R.id.DocASubmitbtnId);
        Calendar c = Calendar.getInstance();


        patient_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DocListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m = month+1;
                        patient_date.setText(year+"/"+m+"/"+dayOfMonth);
                    }
                },y,m,d);
                datePickerDialog.show();
            }
        });
        submitBTNa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = patient_name.getText().toString().trim();
                String phone = patient_phone.getText().toString().trim();
                if(name.equals("") && phone.equals("") && patient_date.getText().toString().equals("")){
                    Toast.makeText(DocListActivity.this, "You should input your details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Cursor checkDate = docADB.checkAvailibility(patient_date.getText().toString().trim());
                    if(checkDate.getCount()<5){
                        long rowID = docADB.InsertPatientData(name,phone,patient_date.getText().toString());
                        if (rowID == -1){
                            Toast.makeText(DocListActivity.this,"Unsuccessful",Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();

                        }else {
                            Toast.makeText(DocListActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                            alertDialog.cancel();

                        }
                    }
                    else {
                        Toast.makeText(DocListActivity.this, "Seat fill up.Try another date", Toast.LENGTH_SHORT).show();

                    }



                }
            }
        });
    }

    private void Initialize() {
        ACallBTN = (Button) findViewById(R.id.DocACallbtnID);
        BCallBTN = (Button) findViewById(R.id.DocBCallbtnID);
        CCallBTN = (Button) findViewById(R.id.DocCCallbtnID);
        AppointABTN = (Button) findViewById(R.id.DocAappointbtnID);
        AppointBBTN = (Button) findViewById(R.id.DocBappointbtnID);
        AppointCBTN = (Button) findViewById(R.id.DocCappointbtnID);

        homeDocIV = (ImageView) findViewById(R.id.DocHomeIVID);
    }

    private void RequestPermission() {
        ActivityCompat.requestPermissions(DocListActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }



}