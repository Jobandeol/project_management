package com.example.dell.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        Handler hn = new Handler();
        hn.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(start.this, MainActivity.class);
                startActivity(i);

                finish();

            }
        }, 3000);

    }
}
