package com.example.dell.myapplication;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 4/25/2017.
 */

public class project_name_adapter extends RecyclerView.Adapter<pname_view_holder> {


    JSONArray jarr;
    Activity a;

    public project_name_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr;
        this.a =a;
    }

    @Override
    public pname_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        pname_view_holder view = new  pname_view_holder(LayoutInflater.from(a).inflate(R.layout.activity_project_name_cell,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(pname_view_holder holder, int position) {

        try {
            final JSONObject job= (JSONObject) jarr.get(position);

            holder.pname.setText(job.getString("Title"));
            holder.pname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    @Override
    public int getItemCount() {
        return jarr.length();
    }
}
