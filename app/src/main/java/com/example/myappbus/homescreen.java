package com.example.myappbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class homescreen extends AppCompatActivity {
    FirebaseAuth myauth;
    Button log_out, startbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Objects.requireNonNull(getSupportActionBar()).hide();
        startbook = findViewById(R.id.btnbooking);
        log_out = findViewById(R.id.btnlogout);
        myauth = FirebaseAuth.getInstance();
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homescreen.this, loginpage.class));
            }
        });
        startbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homescreen.this, bookingpage.class));
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = myauth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(homescreen.this, loginpage.class));
        }
    }
}