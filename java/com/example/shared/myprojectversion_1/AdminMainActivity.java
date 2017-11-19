package com.example.shared.myprojectversion_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMainActivity extends AppCompatActivity {

    Button postAssignment, postEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);


    postAssignment = (Button)findViewById(R.id.adminAssignment);
        postEvent = (Button)findViewById(R.id.adminEvent);

        postAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminMainActivity.this,AdminAssignmentActivity.class);
                startActivity(i);
            }
        });

        postEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminMainActivity.this,AdminEventActivity.class);
                startActivity(i);
            }
        });

    }
}
