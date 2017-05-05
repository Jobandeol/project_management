package com.example.dell.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class project_adapter_2 extends RecyclerView.Adapter<view_holder_2> {


    JSONArray jarr2;
    Activity b;

    public project_adapter_2(JSONArray jarr2 , Activity b)
    {
        this.jarr2 = jarr2;
        this.b =b ;
    }

    @Override
    public view_holder_2 onCreateViewHolder(ViewGroup parent, int viewType){
    view_holder_2 view = new  view_holder_2(LayoutInflater.from(b).inflate(R.layout.activity_cell_2,parent,false));
    return view;}


    @Override
    public void onBindViewHolder(view_holder_2 holder, int position) {

        try {
            final JSONObject job= (JSONObject) jarr2.get(position);

            holder.blank.setText(job.getString("member_email"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jarr2.length();
    }
}
