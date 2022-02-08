package com.example.myappbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        lottieAnimationView = findViewById(R.id.animatebus);

        lottieAnimationView.animate().translationY(1900).setDuration(2000).setStartDelay(11000);
        Thread background = new Thread(() -> {
            try {
                Thread.sleep(7*1000);
                Intent i=new Intent(getBaseContext(),loginpage.class);
                startActivity(i);
                finish();
            } catch (Exception ignored) {
            }
        });
        background.start();
        new Handler().postDelayed(() -> {
            Intent i = new Intent(MainActivity.this, loginpage.class);

            startActivity(i);

            finish();

        }, 7*1000);

}}