package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class view_holder_2 extends RecyclerView.ViewHolder {
    TextView blank;


    public view_holder_2(View itemView) {
        super(itemView);

        blank=(TextView) itemView.findViewById(R.id.t_blnk);


    }
}
