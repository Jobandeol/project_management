package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;

public class signup_activity extends AppCompatActivity {

    EditText edit;Button button1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);

        edit=(EditText) findViewById(R.id.Edit_text);
        button1=(Button) findViewById(R.id.Button1);

        if(!getIntent().getStringExtra("email").equals(""))
        {
            edit.setText(getIntent().getStringExtra("email"));
        }


    }
    public void next(View v){

        String email = edit.getText().toString();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(signup_activity.this , "please enter correct email type" , Toast.LENGTH_SHORT).show();
            return;
        }
        Intent i= new Intent( signup_activity.this,password_confirm.class);

        i.putExtra("email_key",email);
        startActivity(i);
        finish();
    }

}
