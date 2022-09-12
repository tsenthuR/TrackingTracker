package com.example.kisho.trackingtracker.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kisho.trackingtracker.R;
import com.example.kisho.trackingtracker.admin.HomeAdminActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.Buffer;

public class SignupActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase
            .getInstance().getReferenceFromUrl("https://trackingtracker-3a12f-default-rtdb.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        final TextInputEditText username=findViewById(R.id.editTextSignUsername);
       final TextInputEditText email=findViewById(R.id.editTextEmailId);
       final TextInputEditText phonenumber=findViewById(R.id.editTextPhonenumber);
       final TextInputEditText password=findViewById(R.id.editTextSignPassword);

        final Button regiterbtn=findViewById(R.id.buttonsignregister);
        final Button loginbtn=findViewById(R.id.buttonsignLogin);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoLogin=new Intent(SignupActivity.this,LoginUserActivity.class);
                startActivity(gotoLogin);
            }
        });
        


        regiterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String usernametxt=username.getText().toString();
                final String emaitxt=email.getText().toString();
                final  String phonenumbertxt=phonenumber.getText().toString();
                final String passwordtxt=password.getText().toString();


                if (usernametxt.isEmpty()||emaitxt.isEmpty()||phonenumbertxt.isEmpty()||passwordtxt.isEmpty()){
                    Toast.makeText(SignupActivity.this, "Please fill all values", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("usersDetails").child(usernametxt).child("username").setValue(usernametxt);
                            databaseReference.child("usersDetails").child(usernametxt).child("email").setValue(emaitxt);
                            databaseReference.child("usersDetails").child(usernametxt).child("phonenumber").setValue(phonenumbertxt);
                            databaseReference.child("usersDetails").child(usernametxt).child("password").setValue(passwordtxt);

                            Toast.makeText(SignupActivity.this, "Register Suess!!", Toast.LENGTH_SHORT).show();

                            Intent gotoHome=new Intent(SignupActivity.this, HomeUserActivity.class);
                            startActivity(gotoHome);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


            }
        });



    }


}