package com.example.dell.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class Newproject extends AppCompatActivity {


    EditText project_name, desc, due_date_et, start_date_et;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newproject);
        project_name = (EditText) findViewById(R.id.et_my_project);
        desc = (EditText) findViewById(R.id.et_descrptn);
        due_date_et = (EditText) findViewById(R.id.et_dd);
        start_date_et = (EditText) findViewById(R.id.start_date);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void plus(View view) {
        String projectname = project_name.getText().toString();

        if (projectname.equals("")) {
            Toast.makeText(Newproject.this, "please enter Project Name", Toast.LENGTH_SHORT).show();
            return;
        }

        String description = desc.getText().toString();

        if (description.equals("")) {
            Toast.makeText(Newproject.this, "please enter project description", Toast.LENGTH_SHORT).show();
            return;
        }

        String due_date = due_date_et.getText().toString();

        if (due_date.equals("")) {
            Toast.makeText(Newproject.this, "please enter Due Date", Toast.LENGTH_SHORT).show();
            return;
        }

        String start_date = start_date_et.getText().toString();
        if (start_date.equals("")) {
            Toast.makeText(Newproject.this, "please enter Start Date", Toast.LENGTH_SHORT).show();
            return;
        }




    JSONObject job = new JSONObject();



        // code to get user saved id during login

        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);
        String id =  sp.getString("user_id" , "");

        try {
            job.put("pname_key",projectname);
            job.put("desc_key",description);
            job.put("sdate_key",start_date);
            job.put("ddate_key",due_date);
            job.put("u_id_key" , id );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);


        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+joban.abc+"/project/add_project.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    if(response.getString("response_key").equals("done"))
                    {
                        Toast.makeText(Newproject.this , "registered successfully " , Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    if(response.getString("response_key").equals("not done"))
                    {
                        Toast.makeText(Newproject.this , "error try again" , Toast.LENGTH_SHORT).show();

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

        AppController app = new AppController(Newproject.this);

        app.addToRequestQueue(jobreq);


    }

    public void show_calender(View view) {
        Calendar mcurrentDate = Calendar.getInstance();
        final int year = mcurrentDate.get(Calendar.YEAR);
        final int month = mcurrentDate.get(Calendar.MONTH);
        final int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog mDatePicker = new DatePickerDialog(Newproject.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                String date = String.valueOf(selectedyear) + "-" + String.valueOf(selectedmonth) + "-" + String.valueOf(selectedday);
                start_date_et.setText(date);
            }
        }, year, month, day);

        mDatePicker.setTitle("Please select date");
        // TODO Hide Future Date Here
        //mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

        // TODO Hide Past Date Here
        //  mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
        mDatePicker.show();
    }

    public void dd(View view) {
        Calendar mcurrentDate = Calendar.getInstance();
        final int year = mcurrentDate.get(Calendar.YEAR);
        final int month = mcurrentDate.get(Calendar.MONTH);
        final int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog mDatePicker = new DatePickerDialog(Newproject.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {


                String date = String.valueOf(selectedyear) + "-" + String.valueOf(selectedmonth) + "-" + String.valueOf(selectedday);

                due_date_et.setText(date);


            }
        }, year, month, day);

        mDatePicker.setTitle("Please select date");
        //TODO Hide Future Date Here
        //mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

        // TODO Hide Past Date Here
        //  mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
        mDatePicker.show();
    }




}



