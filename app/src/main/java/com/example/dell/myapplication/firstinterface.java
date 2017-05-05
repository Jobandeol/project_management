package com.example.dell.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.dell.myapplication.R.layout.cell;

public class firstinterface extends AppCompatActivity {
   ImageView bell; ImageView search; ImageView clipboard;
    ImageView chat; Button plus,mytasks;
    DrawerLayout d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstinterface);

        bell=(ImageView)findViewById(R.id.notification);
        search=(ImageView)findViewById(R.id.search);
        clipboard=(ImageView)findViewById(R.id.clipboard);
        chat=(ImageView)findViewById(R.id.chats);
        mytasks=(Button)findViewById(R.id.mytasks);
        plus=(Button)findViewById(R.id.plus_btn);
        d =(DrawerLayout)findViewById(R.id.iv_more);



    }

        public void image_bell(View view){
    Intent i= new Intent( firstinterface.this,notification_click.class);
    startActivity(i);}

    public void image_more(View view){
        d.openDrawer(Gravity.LEFT);

    }
    public void image_search(View view){
        Intent i = new Intent(firstinterface.this,search_click.class);
        startActivity(i);
    }
    public void image_clipboard (View view){
        Intent i = new Intent(firstinterface.this,clipboard_next.class);
        startActivity(i);
    }
    public void image_chat (View view){
        Intent i = new Intent(firstinterface.this,conversations_grp.class);
        startActivity(i);
    }
    public void mytask_button (View view){

        Mytasks_click mydialog = new Mytasks_click(firstinterface.this);

        mydialog.show();
    }
    public void btn_plus(View view){
        Intent i = new Intent(firstinterface.this,Newproject.class);
        startActivity(i);
    }

    public void My_Project(View view){
        Intent i = new Intent(firstinterface.this,Myproject.class);
        startActivity(i);
    }

     public void My_Profile(View view){
         Intent i= new Intent(firstinterface.this,My_profile.class);
         startActivity(i);
     }
    public void Logout(View view)
    {
        Intent i = new Intent(firstinterface.this,MainActivity.class);
        startActivity(i);
    }

}
