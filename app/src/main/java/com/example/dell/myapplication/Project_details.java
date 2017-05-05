package com.example.dell.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Project_details extends AppCompatActivity {

    TextView name;

    RecyclerView member_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);

        member_list = (RecyclerView) findViewById(R.id.member_list);

        name = (TextView) findViewById(R.id.name_id);

        String project_name =  getIntent().getStringExtra("name_key");

        name.setText(project_name);

        get_project_members();
    }

    public void cancel(View view) {

        finish();
    }

    public void add_new_member(View view) {

        Intent i = new Intent(Project_details.this , Add_project_memeber.class);

        i.putExtra("project_id", getIntent().getStringExtra("project_id"));

        startActivity(i);


    }

    public void get_project_members(){





        JSONObject job = new JSONObject();

        try {
            job.put("project_id" , getIntent().getStringExtra("project_id"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+joban.abc+"/project/get_project_member.php", job,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if(response.getString("key").equals("done"))
                            {
                                JSONArray jarr = response.getJSONArray("members");

                                project_adapter_2 ad = new project_adapter_2(jarr , Project_details.this);

                               member_list.setLayoutManager(new LinearLayoutManager(Project_details.this , LinearLayoutManager.VERTICAL , false));

                                member_list.setAdapter(ad);




                            }
                            else {
                                Toast.makeText(Project_details.this , "error" , Toast.LENGTH_SHORT).show();
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

        AppController app = new AppController(Project_details.this);
        app.addToRequestQueue(jobjreq);

    }
}
