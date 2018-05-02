package com.example.android_job_project.stringofobjects;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android_job_project.R;

import java.util.ArrayList;

/**
 * Created by Dell on 01-05-2018.
 */

public class UserAdapater extends RecyclerView.Adapter<UserAdapater.MyViewHolder> {

    private Context context;
    private ArrayList<Model> models;

    public UserAdapater(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
           MyViewHolder myViewHolder=(MyViewHolder)holder;
           Model model=models.get(position);
           myViewHolder.id.setText(model.getId()+"");
           myViewHolder.name.setText(model.getName());
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
        }
    }
}
