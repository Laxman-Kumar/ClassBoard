package com.example.shared.myprojectversion_1;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner regSpinner;
    String semSelected;
    private EditText inputEmail, inputPassword,inputEnrollment;
    private Button  btnSignUp;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    private FirebaseDatabase mfirebaseDatabase;
    private FirebaseUser user;
    private String uid;
    UserDataClass newUser;

    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.regProgressBar);
        btnSignUp = (Button) findViewById(R.id.regButton);

        regSpinner = (Spinner)findViewById(R.id.regSpinner);
        regSpinner.setOnItemSelectedListener(this);
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
        regSpinner.setAdapter(dataAdapter);

        inputEmail = (EditText) findViewById(R.id.regEmail);
        inputPassword = (EditText) findViewById(R.id.regPassword);
        inputEnrollment = (EditText) findViewById(R.id.regEnrollment);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String enroll = inputEnrollment.getText().toString().trim();

                boolean checkFrom = validateForm(email,enroll,password);

                if(checkFrom){

                    createAccount(email,password,enroll);
                   // addUserDatatoDatabase();


                }
            }});
    }

    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mfirebaseDatabase.getReference();
    }

    private void addUserDatatoDatabase(){
        initFirebase();

        mDatabaseReference.child("my_app_user").child(newUser.getUuid()).setValue(newUser).
                addOnCompleteListener(RegisterActivity.this,
                        new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {

                                    progressBar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(RegisterActivity.this, "Authentication success",
                                            Toast.LENGTH_SHORT).show();

                                    finish();
                                }
                            }
                        });
    }

    private void createAccount(final String email,final String password,final String enroll){
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Please try again",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Successfull regsitered",
                                    Toast.LENGTH_SHORT).show();
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user != null) {
                                uid = user.getUid();
                                newUser = new UserDataClass(uid,email, password, enroll, semSelected);
                               addUserDatatoDatabase();

                            }
                            }
                        }
                });


    }


    @Override
    protected void onResume() {
        super.onResume();

    }

   @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(i!=0) {
            semSelected = adapterView.getItemAtPosition(i).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(adapterView.getContext(), "Select semester from dropdown", Toast.LENGTH_LONG).show();
        getCurrentFocus();
    }


    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "ict.gnu.ac.in$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateForm(String email,String enroll,String password){


        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(enroll)) {
            Toast.makeText(getApplicationContext(), "Enter enrollment no", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (enroll.length() != 11) {
            Toast.makeText(getApplicationContext(), "Ente Valid enrollment", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!isValidEmail(email)) {
            Toast.makeText(getApplicationContext(), "Enter official email id!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
