package com.example.rimisfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    Button testBTN;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    AlertDialog.Builder logoutdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        testBTN =(Button)findViewById(R.id.Testbtn_id);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutID);
        navigationView = (NavigationView) findViewById(R.id.NavigationviewID);
        toolbar = (Toolbar) findViewById(R.id.ToolbarID);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.HelpMenuID) {
                    Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId()==R.id.AboutMenuID) {
                    Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId()==R.id.ThanksMenuID) {
                    Intent intent = new Intent(HomeActivity.this, ThanksActivity.class);
                    startActivity(intent);
                    //finish();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId()==R.id.LogoutMenuID) {
                    NavMenu_LogoutMethod();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });


        testBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }

    public void NavMenu_LogoutMethod(){
        logoutdialog = new AlertDialog.Builder(HomeActivity.this);
        logoutdialog.setTitle("Log out");
        logoutdialog.setMessage("Do you want to logout?");
        logoutdialog.setIcon(R.drawable.logout);
        logoutdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        logoutdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = logoutdialog.create();
        alertDialog.show();
    }
}