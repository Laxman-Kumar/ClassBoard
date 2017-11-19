package com.example.shared.myprojectversion_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {

    private ArrayList<AssignmentsData> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSubject;
        TextView textViewAssignment;
        TextView textViewDescp;
        TextView textViewPosted;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewSubject = (TextView) itemView.findViewById(R.id.textSub);
            this.textViewAssignment = (TextView) itemView.findViewById(R.id.textAss);
            this.textViewDescp = (TextView) itemView.findViewById(R.id.textDesc);
            this.textViewPosted = (TextView) itemView.findViewById(R.id.textPosted);
        }
    }

    public CustomAdaptor(ArrayList<AssignmentsData> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewSubject = holder.textViewSubject;
        TextView textViewAssignment  = holder.textViewAssignment;
        TextView textViewDescp = holder.textViewDescp;
        TextView textViewPosted = holder.textViewPosted;

        textViewSubject.setText(dataSet.get(listPosition).getSubject());
        textViewAssignment.setText(dataSet.get(listPosition).getAssignmentNo());
        textViewDescp.setText(dataSet.get(listPosition).getDescription());
        textViewPosted.setText(dataSet.get(listPosition).getPostedBy());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
