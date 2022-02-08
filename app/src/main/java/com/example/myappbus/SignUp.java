package com.example.myappbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class SignUp extends AppCompatActivity {
    ImageView backarrow;
    Button sign;
    FirebaseAuth myauth;
    EditText regemail;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Objects.requireNonNull(getSupportActionBar()).hide();
        myauth = FirebaseAuth.getInstance();
        backarrow = findViewById(R.id.back_arrow);
        sign = findViewById(R.id.btnsignup);
        regemail = findViewById(R.id.editemail);
        password = findViewById(R.id.editpass);


        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }
    private void createUser(){
        String emailtxt = regemail.getText().toString();
        String passwordtxt = password.getText().toString();

        if (TextUtils.isEmpty(emailtxt)){
            regemail.setError("Email cannot be empty");
            regemail.requestFocus();
        }else if (TextUtils.isEmpty(passwordtxt)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }else{
            myauth.createUserWithEmailAndPassword(emailtxt,passwordtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUp.this,"User registered successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this,loginpage.class));
                    }else{
                        Toast.makeText(SignUp.this, "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}