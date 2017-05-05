package com.example.dell.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Add_project_memeber extends AppCompatActivity {

    EditText email_et;
    TextView email_id , add_member_text;

    String found_email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project_memeber);

        email_et = (EditText) findViewById(R.id.email_et);

        email_id = (TextView) findViewById(R.id.email_id);

        add_member_text = (TextView) findViewById(R.id.add_member);




    }

    public void search_member(View view) {


        String email = email_et.getText().toString();



        if (email.equals(""))
        {
            Toast.makeText(Add_project_memeber.this, "please enter user email" ,Toast.LENGTH_SHORT).show();
            return;}


        JSONObject job = new JSONObject();

        try {
            job.put("email_key" , email);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+joban.abc+"/project/get_user.php", job,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if(response.getString("key").equals("done"))
                            {
                                String email = response.getJSONObject("user").getString("Email");

                                found_email = email;

                                add_member_text.setVisibility(View.VISIBLE);
                                email_id.setText(email);
                            }
                            else if (response.getString("key").equals("not done")){
                                Toast.makeText(Add_project_memeber.this , "user not found" , Toast.LENGTH_SHORT).show();
                            }

                            else {
                                Toast.makeText(Add_project_memeber.this , "error" , Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 ,2));

        AppController app = new AppController(Add_project_memeber.this);
        app.addToRequestQueue(jobjreq);

    }

    public void add_new_member(View v)
    {
        JSONObject job = new JSONObject();

        try {
            job.put("email_key" , found_email);
            job.put("project_id" , getIntent().getStringExtra("project_id"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+joban.abc+"/project/add_project_member.php", job,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if(response.getString("key").equals("done"))
                            {
                                Toast.makeText(Add_project_memeber.this , "member added successfully" , Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else if (response.getString("key").equals("not done")){
                                Toast.makeText(Add_project_memeber.this , "error" , Toast.LENGTH_SHORT).show();
                            }

                            else {
                                Toast.makeText(Add_project_memeber.this , "error" , Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 ,2));

        AppController app = new AppController(Add_project_memeber.this);
        app.addToRequestQueue(jobjreq);
    }

    public void cancel(View view) {

        finish();
    }
}
