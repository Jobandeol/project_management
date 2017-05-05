package com.example.dell.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Myproject extends AppCompatActivity {
    RecyclerView rcycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myproject);

        rcycle=(RecyclerView)findViewById(R.id.recyc);

        get_projects();
    }

    public void get_projects(){


        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);
        String id =  sp.getString("user_id" , "");



        JSONObject job = new JSONObject();

        try {
            job.put("id_key" ,id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+joban.abc+"/project/get_projects.php", job,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if(response.getString("key").equals("done"))
                            {
                                JSONArray jarr = response.getJSONArray("projects");

                                project_adapter ad = new project_adapter(jarr , Myproject.this);

                                rcycle.setLayoutManager(new LinearLayoutManager(Myproject.this , LinearLayoutManager.VERTICAL , false));

                                rcycle.setAdapter(ad);




                            }
                            else {
                                Toast.makeText(Myproject.this , "error" , Toast.LENGTH_SHORT).show();
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

        AppController app = new AppController(Myproject.this);
        app.addToRequestQueue(jobjreq);

    }

}




