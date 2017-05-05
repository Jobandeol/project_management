package com.example.dell.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import static android.R.id.edit;

public class Login_page extends AppCompatActivity {

    EditText email_et ,password_et; Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        email_et=(EditText)findViewById(R.id.user_email);
        password_et=(EditText) findViewById(R.id.password);
        login=(Button)findViewById(R.id.Login_button);

    }
    public void login_button(View view){

        String email = email_et.getText().toString();
        String password= password_et.getText().toString();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(Login_page.this, "please enter your  correct email" ,Toast.LENGTH_SHORT).show();
        return;}

        if (password.equals(""))
        {
            Toast.makeText(Login_page.this, "please enter your password" ,Toast.LENGTH_SHORT).show();
            return;

    }
        JSONObject job = new JSONObject();

        try {
            job.put("email_key" , email);
            job.put("pass_key" , password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+joban.abc+"/project/login.php", job,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if(response.getString("key").equals("done"))
                            {
                               String id = response.getString("u_id");

///                                // code to save user id value throught app
                                SharedPreferences.Editor sp = getSharedPreferences("user_info" , MODE_PRIVATE).edit();
                                sp.putString("user_id" , id);
                                sp.commit();

                                Intent i= new Intent( Login_page.this,firstinterface.class);


                                startActivity(i);
                            }
                            else {
                                Toast.makeText(Login_page.this , "error" , Toast.LENGTH_SHORT).show();
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

        AppController app = new AppController(Login_page.this);
        app.addToRequestQueue(jobjreq);

    }

}
