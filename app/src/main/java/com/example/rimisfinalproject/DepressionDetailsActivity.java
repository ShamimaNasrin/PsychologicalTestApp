package com.example.rimisfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DepressionDetailsActivity extends AppCompatActivity {
    ImageView detailsDocIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression_details);
        detailsDocIV = (ImageView) findViewById(R.id.detailsHomeIVID);

        detailsDocIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DepressionDetailsActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}