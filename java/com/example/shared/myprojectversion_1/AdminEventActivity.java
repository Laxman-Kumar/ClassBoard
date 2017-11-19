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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

public class AdminEventActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ProgressBar circular_progress;

    public FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    public Spinner clubSp;
    private EditText input_eventName, input_desc, input_postedBy;
    public Button submit;


    String s1_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_event);

        clubSp = (Spinner) findViewById(R.id.spinnerClub);
        clubSp.setOnItemSelectedListener(this);


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                DataList.getClubName()) {
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
        clubSp.setAdapter(dataAdapter);

        circular_progress = (ProgressBar) findViewById(R.id.progressBar2);
        input_eventName = (EditText) findViewById(R.id.inputEventname);
        input_desc = (EditText) findViewById(R.id.inputEventDesc);
        input_postedBy = (EditText) findViewById(R.id.inputEventpostedBy);


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

        if (adapterView.getId() == R.id.spinnerClub) {
            if(i!=0) {
                s1_selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), s1_selected, Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void addEventFirebaseListener() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss MMM-dd", Locale.ENGLISH);
        String formatedDate = df.format(c.getTime());

       EventClass eventClass = new EventClass(UUID.randomUUID().toString(),
                                    input_postedBy.getText().toString(),
                                    input_eventName.getText().toString(),
                                    input_desc.getText().toString(),
                                    s1_selected,
                                    formatedDate);


        mdatabaseReference.child("Event").child(eventClass.getUid()).setValue(eventClass);

        circular_progress.setVisibility(View.INVISIBLE);
        // clearEdittext();

    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mdatabaseReference = mfirebaseDatabase.getReference();
    }
}
