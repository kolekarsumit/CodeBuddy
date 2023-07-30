package com.example.codebuddy2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.codebuddy2.Course.Course_home;
import com.example.codebuddy2.Profile.Profile_Home;
import com.example.codebuddy2.Quesion_Bank.Home_Quesion;
import com.example.codebuddy2.Rate_Us.RateUsDialog;
import com.example.codebuddy2.Test.test_home;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private String name;
    private String mail;
    private  String phone;


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        mail = intent.getStringExtra("mail");
        phone=intent.getStringExtra("phone");

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);


        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.navigation_courses) {
                    Intent intent = new Intent(MainActivity.this, Course_home.class);
                    startActivity(intent);

                } else if (id == R.id.navigation_question_bank) {
                    Intent intent = new Intent(MainActivity.this, Home_Quesion.class);
                    startActivity(intent);

                } else if (id == R.id.navigation_test) {
                    Intent intent = new Intent(MainActivity.this, test_home.class);
                    startActivity(intent);

                } else if (id == R.id.navigation_share) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Code Buddy");
                        intent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                        startActivity(Intent.createChooser(intent, "Share With"));
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Unable to Share", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }


                } else if (id == R.id.navigation_rateus) {
                    RateUsDialog rateUsDialog = new RateUsDialog(MainActivity.this);
                    rateUsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
                    rateUsDialog.setCancelable(false);
                    rateUsDialog.show();

                } else if (id == R.id.navigation_logout) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);

                } else if (id == R.id.navigation_profile) {


                    Intent intent = new Intent(MainActivity.this, Profile_Home.class);
                    intent.putExtra("email",getIntent().getStringExtra("email"));


                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

//    void Writenewuser() {
//
//
//
//        Data_Model d = new Data_Model(name, phone, mail, "", "");
//
//        String key = databaseReference.child("users").push().getKey();
//        databaseReference.child("users").child(key).setValue(d);
//
//
//    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}