package com.example.shared.myprojectversion_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdaptor2 extends RecyclerView.Adapter<CustomAdaptor2.MyViewHolder> {

    private ArrayList<EventClass> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewClub;
        TextView textViewEventName;
        TextView textViewDescp;
        TextView textViewPosted;
        TextView textDatePosted;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewClub = (TextView) itemView.findViewById(R.id.textClubName);
            this.textViewEventName = (TextView) itemView.findViewById(R.id.textEventName);
            this.textViewDescp = (TextView) itemView.findViewById(R.id.textEventDescp);
            this.textViewPosted = (TextView) itemView.findViewById(R.id.textEventPostedBy);
            this.textDatePosted = (TextView) itemView.findViewById(R.id.textEventDatePosted);
        }
    }

    public CustomAdaptor2(ArrayList<EventClass> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_item2, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewClub = holder.textViewClub;
        TextView textViewEvent  = holder.textViewEventName;
        TextView textViewDescp = holder.textViewDescp;
        TextView textViewPosted = holder.textViewPosted;
        TextView textViewDate = holder.textDatePosted;


        textViewClub.setText(dataSet.get(listPosition).getClubName());
        textViewEvent.setText(dataSet.get(listPosition).getEventName());
        textViewDescp.setText(dataSet.get(listPosition).getDescp());
        textViewPosted.setText(dataSet.get(listPosition).getPostedBy());
        textViewDate.setText(dataSet.get(listPosition).getDatePosted());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
