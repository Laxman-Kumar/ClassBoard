package com.example.shared.myprojectversion_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.password;

public class LoginActivity extends AppCompatActivity {

    TextView forgotPass , newUser,email,password;
    Button loginB;
    private FirebaseAuth mAuth;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotPass = (TextView)findViewById(R.id.loginForgotPass);
        newUser = (TextView)findViewById(R.id.loginNewUser);
        loginB = (Button)findViewById(R.id.loginButton);
        email = (TextView)findViewById(R.id.loginUsername);
        password = (TextView)findViewById(R.id.loginPassword);

        mAuth  = FirebaseAuth.getInstance();

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetActivity.class));
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailText = email.getText().toString();
                String passText = password.getText().toString();


                if(emailText.equals("admin@ict.gnu.ac.in") && passText.equals("ictadmin"))
                {
                        Intent i = new Intent(LoginActivity.this,AdminMainActivity.class);
                        startActivity(i);
                }


                else if(validateForm(emailText,passText)){

                    mAuth.signInWithEmailAndPassword(emailText, passText)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        // there was an error
                                        if (password.length() < 6) {
                                            password.setError("Minimum 6");
                                        } else {
                                            Toast.makeText(LoginActivity.this, "Email or password mismatch", Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        myPref = getSharedPreferences("userData",0);
                                        final SharedPreferences.Editor edt = myPref.edit();

                                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                        if(user!=null){

                                            String uid = user.getUid();
                                            Log.d("UID:", uid);
                                            DatabaseReference dbr = FirebaseDatabase.getInstance().getReference();
                                            dbr.child("my_app_user").child(uid).addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    if(dataSnapshot.exists())
                                                    {
                                                       UserDataClass temp = dataSnapshot.getValue(UserDataClass.class);
                                                        edt.putString("email",temp.getEmail());
                                                        edt.putString("sem",temp.getSemester());
                                                        edt.putString("enroll",temp.getEnroll());
                                                        edt.putString("pass",temp.getPassword());
                                                        edt.apply();
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {

                                                }
                                            });

                                        }
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });
                }}
            });


    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth  = FirebaseAuth.getInstance();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
        myPref = getSharedPreferences("userData",0);
        final String UemailId = myPref.getString("email",null);
        String Upass = myPref.getString("pass",null);

        if(UemailId!=null || Upass!=null){
            mAuth.signInWithEmailAndPassword(UemailId,Upass)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                // there was an error
                                if (password.length() < 6) {
                                    password.setError("Minimum 6");
                                } else {
                                    Toast.makeText(LoginActivity.this, "Email or password mismatch", Toast.LENGTH_LONG).show();
                                }
                            } else {

                                Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);

                                Toast.makeText(LoginActivity.this, "Welcome "+UemailId, Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }
                    });

        }
    }



    private void saveAndCheckPref(){


    }

    private boolean validateForm(String email,String password){
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
