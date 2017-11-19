package com.example.shared.myprojectversion_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SettingActivity extends Fragment {

    TextView settingEmail,settingEnroll,settingSem,signout;
    SharedPreferences myPref;


    public static SettingActivity newInstance(){

        SettingActivity fragment = new SettingActivity();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myPref = getActivity().getSharedPreferences("userData",0);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View RootView = inflater.inflate(R.layout.activity_setting, container, false);

        settingEmail = (TextView)RootView.findViewById(R.id.settingEmail);
        settingEnroll = (TextView)RootView.findViewById(R.id.settingEnroll);
        settingSem  = (TextView)RootView.findViewById(R.id.settingSemester);
        signout = (TextView)RootView.findViewById(R.id.signOut);


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = myPref.edit();
                editor.clear();
                editor.apply();

                Intent i = new Intent(getActivity(),LoginActivity.class);
                startActivity(i);
            }
        });

        settingEmail.setText(myPref.getString("email",null));
        settingEnroll.setText(myPref.getString("enroll",null));
        settingSem.setText(myPref.getString("sem",null));


        return RootView;

    }
}
