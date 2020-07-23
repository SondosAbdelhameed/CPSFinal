package com.cps.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cps.R;

public class Splash extends AppCompatActivity {

    int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                  /*  if (user.isLoged()) {
                        startActivity(new Intent(Splash.this, Home.class));
                    } else {
                        startActivity(new Intent(Splash.this, Login.class));
                    }*/

                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();

            }
        }, SPLASH_TIME_OUT);


    }
}
