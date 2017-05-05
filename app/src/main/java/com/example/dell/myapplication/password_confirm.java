package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class password_confirm extends AppCompatActivity {
   EditText pswrd , cpswrd;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_confirm);

        pswrd=(EditText)findViewById(R.id.Password);

        cpswrd=(EditText)findViewById(R.id.confirm_password);

         email = getIntent().getStringExtra("email_key");

       // Toast.makeText(password_confirm.this, email, Toast.LENGTH_SHORT).show();

    }

    public void save_data(View v)

    {
        String pass = pswrd.getText().toString();
        String cpass = cpswrd.getText().toString();

        if(pass.equals(""))
        {
            Toast.makeText(password_confirm.this, "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(cpass.equals(""))
        {
            Toast.makeText(password_confirm.this, "please re enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if( ! pass.equals(cpass))
        {
            Toast.makeText(password_confirm.this , "password do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        JSONObject job = new JSONObject();

        try {
            job.put("email_key", email);
            job.put("pass_key" , pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+joban.abc+"/project/signup.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    if(response.getString("response_key").equals("done"))
                    {
                        Toast.makeText(password_confirm.this , "registered successfully " , Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    if(response.getString("response_key").equals("not done"))
                    {
                        Toast.makeText(password_confirm.this , "error try again" , Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);
            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 3 , 2 ));

        AppController app = new AppController(password_confirm.this);

        app.addToRequestQueue(jobreq);



    }


}
