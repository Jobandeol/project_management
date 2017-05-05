package com.example.dell.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class search_click extends AppCompatActivity {
 ImageView previous; EditText spp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_click);

        previous=(ImageView)findViewById(R.id.image_previous);
        spp=(EditText)findViewById(R.id.et_spp);
    }

    public void previous(View view){
        Intent i = new Intent(search_click.this,firstinterface.class);
        startActivity(i);
    }


}
