package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class notification_click extends AppCompatActivity {
    ImageView backarrow; TextView inbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_click);
        backarrow = (ImageView) findViewById(R.id.arrows);
        inbox = (TextView) findViewById(R.id.inbox);

    }

    public void image_back_arrow(View view){

        Intent i = new Intent(notification_click.this,firstinterface.class);
        startActivity(i);
    }
}
