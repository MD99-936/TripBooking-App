package com.example.myappbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class loginpage extends AppCompatActivity {
    TextView create;
    FirebaseAuth myauth;
    EditText thepassword;
    EditText theemail;
    Button myloginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        Objects.requireNonNull(getSupportActionBar()).hide();
        create = (TextView) findViewById(R.id.createnewacc);
        thepassword = (EditText) findViewById(R.id.mypass);
        theemail = (EditText) findViewById(R.id.myemail);
        myloginbtn = (Button) findViewById(R.id.btnlogin);
        myauth = FirebaseAuth.getInstance();


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(loginpage.this, SignUp.class);
                startActivity(k);
            }
        });

        myloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


    }
    private void loginUser(){
        String emailtxt = theemail.getText().toString();
        String passwordtxt = thepassword.getText().toString();

        if (TextUtils.isEmpty(emailtxt)){
            theemail.setError("Email cannot be empty");
            theemail.requestFocus();
        }else if (TextUtils.isEmpty(passwordtxt)){
            thepassword.setError("Password cannot be empty");
            thepassword.requestFocus();
        }else{
            myauth.signInWithEmailAndPassword(emailtxt,passwordtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(loginpage.this,"User logged in successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginpage.this,homescreen.class));
                    }else{
                        Toast.makeText(loginpage.this, "Log in Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}