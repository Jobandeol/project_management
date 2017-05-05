package com.example.dell.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

public class add_task_click extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_click);
    }
    public void due_cal(View view) {

        Calendar mcurrentDate = Calendar.getInstance();
        final int year = mcurrentDate.get(Calendar.YEAR);
        final int month = mcurrentDate.get(Calendar.MONTH);
        final int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog mDatePicker = new DatePickerDialog(add_task_click.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {


            }
        }, year, month, day);

        // mDatePicker.setTitle("Please select date");
        // TODO Hide Future Date Here
        //mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

        // TODO Hide Past Date Here
        //  mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
        mDatePicker.show();
    }
}
