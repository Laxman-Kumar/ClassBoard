package com.example.shared.myprojectversion_1;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class AdminAssignmentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ProgressBar circular_progress;

    public FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    public Spinner semesterSp, subjectSp;
    private EditText input_assignment, input_desc, input_postedBy;
    public Button submit;


    String s1_selected, s2_selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_assignment);


        semesterSp = (Spinner) findViewById(R.id.semesterSpinner);
        subjectSp = (Spinner) findViewById(R.id.spinnerSubject);

        semesterSp.setOnItemSelectedListener(this);
        subjectSp.setOnItemSelectedListener(this);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                DataList.getSemesterList()) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the disable item text color
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesterSp.setAdapter(dataAdapter);

        circular_progress = (ProgressBar) findViewById(R.id.progressBar2);
        input_assignment = (EditText) findViewById(R.id.inputAssignmentNo);
        input_desc = (EditText) findViewById(R.id.inputDesc);
        input_postedBy = (EditText) findViewById(R.id.inputpostedBy);


        submit = (Button) findViewById(R.id.submitData);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFirebase();
                addEventFirebaseListener();
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (adapterView.getId() == R.id.semesterSpinner) {
            if(i!=0) {
                ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        DataList.getSubject(i));

                dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                subjectSp.setAdapter(dataAdapter1);

                s1_selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), s1_selected, Toast.LENGTH_SHORT).show();
            }

        } else if (adapterView.getId() == R.id.spinnerSubject) {
            s2_selected = adapterView.getItemAtPosition(i).toString();
            if (i != 0)
                Toast.makeText(adapterView.getContext(), s2_selected, Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void addEventFirebaseListener() {

        AssignmentsData obj = new AssignmentsData(UUID.randomUUID().toString(),
                s2_selected,
                "Assignment "+input_assignment.getText().toString(),
                input_desc.getText().toString(),
                input_postedBy.getText().toString(),
                s1_selected);


        mdatabaseReference.child("Assignments").child(obj.getSemester()).child(obj.getUid()).setValue(obj);

        circular_progress.setVisibility(View.INVISIBLE);
        // clearEdittext();

    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mdatabaseReference = mfirebaseDatabase.getReference();
    }
}
