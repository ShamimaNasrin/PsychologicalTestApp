package com.example.rimisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Database.Patient_info;

public class QuestionActivity extends AppCompatActivity {
    Button QOnebtnA,QOnebtnB,QOnebtnC,QOnebtnD,QTwobtnA,QTwobtnB,QTwobtnC,QTwobtnD,QThreebtnA,QThreebtnB,QThreebtnC,QThreebtnD,ResultShowbtn,QFourbtnA,QFourbtnB,QFourbtnC,QFourbtnD,QFivebtnA,QFivebtnB,QFivebtnC,QFivebtnD,QSixbtnA,QSixbtnB,QSixbtnC,QSixbtnD,QSevenbtnA,QSevenbtnB,QSevenbtnC,QSevenbtnD,QEightbtnA,QEightbtnB,QEightbtnC,QEightbtnD,QNinebtnA,QNinebtnB,QNinebtnC,QNinebtnD;

    int Count=0;
    Patient_info patientInfoDB;
    boolean mildvalue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initialization();

        patientInfoDB = new Patient_info(this);
        SQLiteDatabase sqLiteDatabase = patientInfoDB.getWritableDatabase();


        CustomProgressDialog customDialog = new CustomProgressDialog(QuestionActivity.this);

        //Question One
        QOnebtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count=0;
                //QOnebtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QOnebtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QOnebtnA.setTextColor(getResources().getColor(R.color.white));
                QOnebtnB.setClickable(false);
                QOnebtnC.setClickable(false);
                QOnebtnD.setClickable(false);

                QOnebtnA.setClickable(false);


            }
        });

        QOnebtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count=1;
                //QOnebtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QOnebtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QOnebtnB.setTextColor(getResources().getColor(R.color.white));
                QOnebtnA.setClickable(false);
                QOnebtnC.setClickable(false);
                QOnebtnD.setClickable(false);

                QOnebtnB.setClickable(false);

            }
        });

        QOnebtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count=2;
                //QOnebtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QOnebtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QOnebtnC.setTextColor(getResources().getColor(R.color.white));
                QOnebtnA.setClickable(false);
                QOnebtnB.setClickable(false);
                QOnebtnD.setClickable(false);

                QOnebtnC.setClickable(false);

            }
        });

        QOnebtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count=3;
                //QOnebtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QOnebtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QOnebtnD.setTextColor(getResources().getColor(R.color.white));
                QOnebtnA.setClickable(false);
                QOnebtnB.setClickable(false);
                QOnebtnC.setClickable(false);

                QOnebtnD.setClickable(false);

            }
        }); //Q_One END

        //Question Two
        QTwobtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 1;
                //QTwobtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QTwobtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QTwobtnA.setTextColor(getResources().getColor(R.color.white));
                QTwobtnB.setClickable(false);
                QTwobtnC.setClickable(false);
                QTwobtnD.setClickable(false);

                QTwobtnA.setClickable(false);

            }
        });

        QTwobtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QTwobtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QTwobtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QTwobtnB.setTextColor(getResources().getColor(R.color.white));
                QTwobtnA.setClickable(false);
                QTwobtnC.setClickable(false);
                QTwobtnD.setClickable(false);

                QTwobtnB.setClickable(false);

            }
        });

        QTwobtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QTwobtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QTwobtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QTwobtnC.setTextColor(getResources().getColor(R.color.white));
                QTwobtnA.setClickable(false);
                QTwobtnB.setClickable(false);
                QTwobtnD.setClickable(false);

                QTwobtnC.setClickable(false);

            }
        });

        QTwobtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QTwobtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QTwobtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QTwobtnD.setTextColor(getResources().getColor(R.color.white));
                QTwobtnA.setClickable(false);
                QTwobtnB.setClickable(false);
                QTwobtnC.setClickable(false);

                QTwobtnD.setClickable(false);

            }
        }); // Q_Two END


        //Question Three
        QThreebtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QThreebtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QThreebtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QThreebtnA.setTextColor(getResources().getColor(R.color.white));
                QThreebtnB.setClickable(false);
                QThreebtnC.setClickable(false);
                QThreebtnD.setClickable(false);

                QThreebtnA.setClickable(false);

            }
        });

        QThreebtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QThreebtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QThreebtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QThreebtnB.setTextColor(getResources().getColor(R.color.white));
                QThreebtnA.setClickable(false);
                QThreebtnC.setClickable(false);
                QThreebtnD.setClickable(false);

                QThreebtnB.setClickable(false);

            }
        });

        QThreebtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QThreebtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QThreebtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QThreebtnC.setTextColor(getResources().getColor(R.color.white));
                QThreebtnA.setClickable(false);
                QThreebtnB.setClickable(false);
                QThreebtnD.setClickable(false);

                QThreebtnC.setClickable(false);

            }
        });

        QThreebtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QThreebtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QThreebtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QThreebtnD.setTextColor(getResources().getColor(R.color.white));
                QThreebtnA.setClickable(false);
                QThreebtnB.setClickable(false);
                QThreebtnC.setClickable(false);

                QThreebtnD.setClickable(false);

            }
        }); //Q_Three END


        //Question Four
        QFourbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QFourbtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFourbtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFourbtnA.setTextColor(getResources().getColor(R.color.white));
                QFourbtnB.setClickable(false);
                QFourbtnC.setClickable(false);
                QFourbtnD.setClickable(false);

                QFourbtnA.setClickable(false);

            }
        });

        QFourbtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QFourbtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFourbtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFourbtnB.setTextColor(getResources().getColor(R.color.white));
                QFourbtnA.setClickable(false);
                QFourbtnC.setClickable(false);
                QFourbtnD.setClickable(false);

                QFourbtnB.setClickable(false);

            }
        });

        QFourbtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QFourbtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFourbtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFourbtnC.setTextColor(getResources().getColor(R.color.white));
                QFourbtnA.setClickable(false);
                QFourbtnB.setClickable(false);
                QFourbtnD.setClickable(false);

                QFourbtnC.setClickable(false);

            }
        });

        QFourbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QFourbtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFourbtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFourbtnD.setTextColor(getResources().getColor(R.color.white));
                QFourbtnA.setClickable(false);
                QFourbtnB.setClickable(false);
                QFourbtnC.setClickable(false);

                QFourbtnD.setClickable(false);

            }
        }); //Q_Four END

        //Question Five
        QFivebtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QFivebtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFivebtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFivebtnA.setTextColor(getResources().getColor(R.color.white));
                QFivebtnB.setClickable(false);
                QFivebtnC.setClickable(false);
                QFivebtnD.setClickable(false);

                QFivebtnA.setClickable(false);

            }
        });

        QFivebtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QFivebtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFivebtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFivebtnB.setTextColor(getResources().getColor(R.color.white));
                QFivebtnA.setClickable(false);
                QFivebtnC.setClickable(false);
                QFivebtnD.setClickable(false);

                QFivebtnB.setClickable(false);

            }
        });

        QFivebtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QFivebtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFivebtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFivebtnC.setTextColor(getResources().getColor(R.color.white));
                QFivebtnA.setClickable(false);
                QFivebtnB.setClickable(false);
                QFivebtnD.setClickable(false);

                QFivebtnC.setClickable(false);

            }
        });

        QFivebtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QFivebtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QFivebtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QFivebtnD.setTextColor(getResources().getColor(R.color.white));
                QFivebtnA.setClickable(false);
                QFivebtnB.setClickable(false);
                QFivebtnC.setClickable(false);

                QFivebtnD.setClickable(false);

            }
        }); //Q_Five END

        //Question Six
        QSixbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QSixbtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSixbtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSixbtnA.setTextColor(getResources().getColor(R.color.white));
                QSixbtnB.setClickable(false);
                QSixbtnC.setClickable(false);
                QSixbtnD.setClickable(false);

                QSixbtnA.setClickable(false);

            }
        });

        QSixbtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QSixbtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSixbtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSixbtnB.setTextColor(getResources().getColor(R.color.white));
                QSixbtnA.setClickable(false);
                QSixbtnC.setClickable(false);
                QSixbtnD.setClickable(false);

                QSixbtnB.setClickable(false);

            }
        });

        QSixbtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QSixbtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSixbtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSixbtnC.setTextColor(getResources().getColor(R.color.white));
                QSixbtnA.setClickable(false);
                QSixbtnB.setClickable(false);
                QSixbtnD.setClickable(false);

                QSixbtnC.setClickable(false);

            }
        });

        QSixbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QSixbtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSixbtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSixbtnD.setTextColor(getResources().getColor(R.color.white));
                QSixbtnA.setClickable(false);
                QSixbtnB.setClickable(false);
                QSixbtnC.setClickable(false);

                QSixbtnD.setClickable(false);

            }
        }); //Q_Six END

        //Question Seven
        QSevenbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QSevenbtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSevenbtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSevenbtnA.setTextColor(getResources().getColor(R.color.white));
                QSevenbtnB.setClickable(false);
                QSevenbtnC.setClickable(false);
                QSevenbtnD.setClickable(false);

                QSevenbtnA.setClickable(false);

            }
        });

        QSevenbtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QSevenbtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSevenbtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSevenbtnB.setTextColor(getResources().getColor(R.color.white));
                QSevenbtnA.setClickable(false);
                QSevenbtnC.setClickable(false);
                QSevenbtnD.setClickable(false);

                QSevenbtnB.setClickable(false);

            }
        });

        QSevenbtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QSevenbtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSevenbtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSevenbtnC.setTextColor(getResources().getColor(R.color.white));
                QSevenbtnA.setClickable(false);
                QSevenbtnB.setClickable(false);
                QSevenbtnD.setClickable(false);

                QSevenbtnC.setClickable(false);

            }
        });

        QSevenbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QSevenbtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QSevenbtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QSevenbtnD.setTextColor(getResources().getColor(R.color.white));
                QSevenbtnA.setClickable(false);
                QSevenbtnB.setClickable(false);
                QSevenbtnC.setClickable(false);

                QSevenbtnD.setClickable(false);

            }
        }); //Q_seven END

        //Question Eight
        QEightbtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QEightbtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QEightbtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QEightbtnA.setTextColor(getResources().getColor(R.color.white));
                QEightbtnB.setClickable(false);
                QEightbtnC.setClickable(false);
                QEightbtnD.setClickable(false);

                QEightbtnA.setClickable(false);

            }
        });

        QEightbtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QEightbtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QEightbtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QEightbtnB.setTextColor(getResources().getColor(R.color.white));
                QEightbtnA.setClickable(false);
                QEightbtnC.setClickable(false);
                QEightbtnD.setClickable(false);

                QEightbtnB.setClickable(false);

            }
        });

        QEightbtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QEightbtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QEightbtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QEightbtnC.setTextColor(getResources().getColor(R.color.white));
                QEightbtnA.setClickable(false);
                QEightbtnB.setClickable(false);
                QEightbtnD.setClickable(false);

                QEightbtnC.setClickable(false);

            }
        });

        QEightbtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QEightbtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QEightbtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QEightbtnD.setTextColor(getResources().getColor(R.color.white));
                QEightbtnA.setClickable(false);
                QEightbtnB.setClickable(false);
                QEightbtnC.setClickable(false);

                QEightbtnD.setClickable(false);

            }
        }); //Q_Eight END

        //Question Nine
        QNinebtnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count = Count + 0;
                //QNinebtnA.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QNinebtnA.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QNinebtnA.setTextColor(getResources().getColor(R.color.white));
                QNinebtnB.setClickable(false);
                QNinebtnC.setClickable(false);
                QNinebtnD.setClickable(false);

                QNinebtnA.setClickable(false);

            }
        });

        QNinebtnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+1;
                //QNinebtnB.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QNinebtnB.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QNinebtnB.setTextColor(getResources().getColor(R.color.white));
                QNinebtnA.setClickable(false);
                QNinebtnC.setClickable(false);
                QNinebtnD.setClickable(false);

                QNinebtnB.setClickable(false);

            }
        });

        QNinebtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+2;
                //QNinebtnC.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QNinebtnC.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QNinebtnC.setTextColor(getResources().getColor(R.color.white));
                QNinebtnA.setClickable(false);
                QNinebtnB.setClickable(false);
                QNinebtnD.setClickable(false);

                QNinebtnC.setClickable(false);

            }
        });

        QNinebtnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count+3;
                //QNinebtnD.setBackgroundColor(getResources().getColor(R.color.purple_200));
                QNinebtnD.setBackground(getResources().getDrawable(R.drawable.btn_bg_design_layout));
                QNinebtnD.setTextColor(getResources().getColor(R.color.white));
                QNinebtnA.setClickable(false);
                QNinebtnB.setClickable(false);
                QNinebtnC.setClickable(false);

                QNinebtnD.setClickable(false);

            }
        }); //Q_Nine END


        ResultShowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Result = Integer.toString(Count);

                if (Count>0 && Count<5){
                    String sever_level = "Minimal depression";
                    mildvalue = true;


                    customDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                            intent.putExtra("SeverityLevel",sever_level);
                            intent.putExtra("Mildvalue",mildvalue);
                            startActivity(intent);
                            customDialog.dismiss();
                            finish();
                        }
                    },6000);

                }
                else if (Count>4 && Count<10){
                    String sever_level = "Mild depression";


                    customDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                            intent.putExtra("SeverityLevel",sever_level);
                            startActivity(intent);
                            customDialog.dismiss();
                            finish();
                        }
                    },6000);

                    //Toast.makeText(HomeActivity.this, "Moderate depression", Toast.LENGTH_SHORT).show();
                }
                else if (Count>9 && Count<15){
                    String sever_level = "Moderate depression";


                    customDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                            intent.putExtra("SeverityLevel",sever_level);
                            startActivity(intent);
                            customDialog.dismiss();
                            finish();
                        }
                    },6000);

                    //Toast.makeText(HomeActivity.this, "Moderate depression", Toast.LENGTH_SHORT).show();
                }
                else if (Count>14 && Count<20){
                    String sever_level = "Moderately Sever depression";


                    customDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                            intent.putExtra("SeverityLevel",sever_level);
                            startActivity(intent);
                            customDialog.dismiss();
                            finish();
                        }
                    },6000);

                    //Toast.makeText(HomeActivity.this, "Moderate depression", Toast.LENGTH_SHORT).show();
                }
                else if (Count>19 && Count<28){
                    String sever_level = "Sever depression";


                    customDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(QuestionActivity.this,ScoreActivity.class);
                            intent.putExtra("SeverityLevel",sever_level);
                            startActivity(intent);
                            customDialog.dismiss();
                            finish();
                        }
                    },6000);

                    //Toast.makeText(HomeActivity.this, "Severe depression", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void initialization(){


        QOnebtnA = (Button)findViewById(R.id.QOnebtnAID);
        QOnebtnB = (Button)findViewById(R.id.QOnebtnBID);
        QOnebtnC = (Button)findViewById(R.id.QOnebtnCID);
        QOnebtnD = (Button)findViewById(R.id.QOnebtnDID);

        QTwobtnA = (Button)findViewById(R.id.QTwobtnAID);
        QTwobtnB = (Button)findViewById(R.id.QTwobtnBID);
        QTwobtnC = (Button)findViewById(R.id.QTwobtnCID);
        QTwobtnD = (Button)findViewById(R.id.QTwobtnDID);

        QThreebtnA = (Button)findViewById(R.id.QThreebtnAID);
        QThreebtnB = (Button)findViewById(R.id.QThreebtnBID);
        QThreebtnC = (Button)findViewById(R.id.QThreebtnCID);
        QThreebtnD = (Button)findViewById(R.id.QThreebtnDID);

        QFourbtnA = (Button)findViewById(R.id.QFourbtnAID);
        QFourbtnB = (Button)findViewById(R.id.QFourbtnBID);
        QFourbtnC = (Button)findViewById(R.id.QFourbtnCID);
        QFourbtnD = (Button)findViewById(R.id.QFourbtnDID);

        QFivebtnA = (Button)findViewById(R.id.QFivebtnAID);
        QFivebtnB = (Button)findViewById(R.id.QFivebtnBID);
        QFivebtnC = (Button)findViewById(R.id.QFivebtnCID);
        QFivebtnD = (Button)findViewById(R.id.QFivebtnDID);

        QSixbtnA = (Button)findViewById(R.id.QSixbtnAID);
        QSixbtnB = (Button)findViewById(R.id.QSixbtnBID);
        QSixbtnC = (Button)findViewById(R.id.QSixbtnCID);
        QSixbtnD = (Button)findViewById(R.id.QSixbtnDID);

        QSevenbtnA = (Button)findViewById(R.id.QSevenbtnAID);
        QSevenbtnB = (Button)findViewById(R.id.QSevenbtnBID);
        QSevenbtnC = (Button)findViewById(R.id.QSevenbtnCID);
        QSevenbtnD = (Button)findViewById(R.id.QSevenbtnDID);

        QEightbtnA = (Button)findViewById(R.id.QEightbtnAID);
        QEightbtnB = (Button)findViewById(R.id.QEightbtnBID);
        QEightbtnC = (Button)findViewById(R.id.QEightbtnCID);
        QEightbtnD = (Button)findViewById(R.id.QEightbtnDID);

        QNinebtnA = (Button)findViewById(R.id.QNinebtnAID);
        QNinebtnB = (Button)findViewById(R.id.QNinebtnBID);
        QNinebtnC = (Button)findViewById(R.id.QNinebtnCID);
        QNinebtnD = (Button)findViewById(R.id.QNinebtnDID);

        ResultShowbtn = (Button)findViewById(R.id.ResultShowbtnID);


        //ResetBTN = (Button)findViewById(R.id.ResetbtnID);


    }
}