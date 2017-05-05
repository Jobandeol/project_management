package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 4/18/2017.
 */

public class project_adapter extends RecyclerView.Adapter<project_view_holder> {

    JSONArray jarr;
    Activity a;

    public project_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr;
        this.a =a;
    }
    @Override
    public project_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        project_view_holder view = new  project_view_holder(LayoutInflater.from(a).inflate(R.layout.cell,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(project_view_holder holder, int position) {

        try {
            final JSONObject job= (JSONObject) jarr.get(position);

            holder.project_name.setText(job.getString("Title"));
            holder.project_description.setText(job.getString("Description"));
            holder.start_date.setText(job.getString("start_date"));
            holder.due_date.setText(job.getString("due_date"));

            holder.details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(a, Project_details.class);

                    try {
                        i.putExtra("name_key",job.getString("Title"));
                        i.putExtra("project_id",job.getString("P_id"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    a.startActivity(i);
                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return  jarr.length();
    }
}
