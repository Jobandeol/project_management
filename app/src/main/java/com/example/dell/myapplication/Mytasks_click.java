package com.example.dell.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class Mytasks_click extends Dialog

{

    public RecyclerView recycler;

    public Activity a ;
    public Mytasks_click(Context context)

    {
        super(context);

        this.a = (Activity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytasks_click);

        recycler = (RecyclerView) findViewById(R.id.recycler_id);

        get_projects();
    }

    public void get_projects(){


        SharedPreferences sp = a.getSharedPreferences("user_info" , MODE_PRIVATE);
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

                                project_name_adapter ad = new project_name_adapter(jarr , a);

                                recycler.setLayoutManager(new LinearLayoutManager(a , LinearLayoutManager.VERTICAL , false));

                                recycler.setAdapter(ad);




                            }
                            else {
                                Toast.makeText(a , "error" , Toast.LENGTH_SHORT).show();
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

        AppController app = new AppController(a);
        app.addToRequestQueue(jobjreq);

    }
}
