package com.example.shared.myprojectversion_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListviewAdapter extends BaseAdapter {
    Activity activity;
    List<AssignmentsData> listuser;
    LayoutInflater inflater;

    public ListviewAdapter(Activity activity, ArrayList<AssignmentsData> listuser) {
        this.activity = activity;
        this.listuser = listuser;
    }

    @Override
    public int getCount() {
        return listuser.size();
    }

    @Override
    public Object getItem(int i) {
        return listuser.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int listPosition, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater)activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item,null);

        TextView textViewSubject = (TextView) itemView.findViewById(R.id.textSub);
        TextView textViewAssignment = (TextView) itemView.findViewById(R.id.textAss);
        TextView textViewDescp = (TextView) itemView.findViewById(R.id.textDesc);
        TextView textViewPosted = (TextView) itemView.findViewById(R.id.textPosted);


        textViewSubject.setText(listuser.get(listPosition).getSubject());
        textViewAssignment.setText(listuser.get(listPosition).getAssignmentNo());
        textViewDescp.setText(listuser.get(listPosition).getDescription());
        textViewPosted.setText(listuser.get(listPosition).getPostedBy());

        return itemView;
    }
}
