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


public class ListviewAdapter2 extends BaseAdapter {
    Activity activity;
    List<EventClass> listuser;
    LayoutInflater inflater;

    public ListviewAdapter2(Activity activity, ArrayList<EventClass> listuser) {
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

        View itemView = inflater.inflate(R.layout.listview_item2,null);

        TextView textViewClub = (TextView) itemView.findViewById(R.id.textClubName);
        TextView textViewEvent = (TextView) itemView.findViewById(R.id.textEventName);
        TextView textViewDescp = (TextView) itemView.findViewById(R.id.textEventDescp);
        TextView textViewPosted = (TextView) itemView.findViewById(R.id.textEventPostedBy);
        TextView textViewDate = (TextView) itemView.findViewById(R.id.textEventDatePosted);


        textViewClub.setText(listuser.get(listPosition).getClubName());
        textViewEvent.setText(listuser.get(listPosition).getEventName());
        textViewDescp.setText(listuser.get(listPosition).getDescp());
        textViewPosted.setText(listuser.get(listPosition).getPostedBy());
        textViewDate.setText(listuser.get(listPosition).getDatePosted());

        return itemView;
    }
}
