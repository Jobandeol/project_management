package com.example.dell.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dell on 4/18/2017.
 */

public class project_view_holder extends RecyclerView.ViewHolder{

    TextView project_name, project_description, start_date, due_date;

    Button details ;
    public project_view_holder(View itemView) {
        super(itemView);

        project_name = (TextView) itemView.findViewById(R.id.t_pn);
        project_description= (TextView) itemView.findViewById(R.id.t_pd);
        start_date= (TextView) itemView.findViewById(R.id.t_sd);
        due_date=(TextView)itemView.findViewById(R.id.t_dd);

        details = (Button) itemView.findViewById(R.id.button);

    }
}
