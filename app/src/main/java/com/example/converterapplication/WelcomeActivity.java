package com.example.converterapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Handler;


public class WelcomeActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Delayed start of MainActivity after splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);

                // Close WelcomeActivity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}