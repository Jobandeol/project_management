package com.example.dell.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dell on 4/25/2017.
 */

public class pname_view_holder extends RecyclerView.ViewHolder {

    TextView pname;

    public pname_view_holder(View itemView) {
        super(itemView);

        pname= (TextView) itemView.findViewById(R.id.tv_pname);
    }
}
