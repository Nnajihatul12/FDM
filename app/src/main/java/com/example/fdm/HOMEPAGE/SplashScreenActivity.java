package com.example.fdm.HOMEPAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

import com.example.fdm.R;


public class SplashScreenActivity extends AppCompatActivity {
Handler h = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        h.postDelayed(new Runnable() {

            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }
}

