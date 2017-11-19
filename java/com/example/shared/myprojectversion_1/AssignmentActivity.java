package com.example.shared.myprojectversion_1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class AssignmentActivity extends Fragment {


    private RecyclerView.LayoutManager layoutManager1;

    private RecyclerView recyclerView1;

    private ArrayList<AssignmentsData> data = new ArrayList<>();

    private FirebaseDatabase mfirebaseDatabase1;
    private DatabaseReference mdatabaseReference;
    String s1_selected;
    SharedPreferences myPref ;

    public static AssignmentActivity newInstance(){

        AssignmentActivity fragment = new AssignmentActivity();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView1 = (RecyclerView) getView().findViewById(R.id.recyclerV);
        layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myPref = getActivity().getSharedPreferences("userData",0);

        s1_selected= myPref.getString("sem",null);



        initFirebase();

        addEventFirebaseListener(s1_selected);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_assignment,container,false);

    }

    private void addEventFirebaseListener(String semCheck) {

        mdatabaseReference.child("Assignments").child(semCheck).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(data.size()>0)
                    data.clear();

                for(DataSnapshot postSnapShot:dataSnapshot.getChildren()){
                    AssignmentsData user = postSnapShot.getValue(AssignmentsData.class);
                    data.add(user);
                }
                CustomAdaptor adapter = new CustomAdaptor(data);
                recyclerView1.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initFirebase() {
        FirebaseApp.initializeApp(getContext());
        mfirebaseDatabase1 = FirebaseDatabase.getInstance();
        mdatabaseReference = mfirebaseDatabase1.getReference();
    }
}
