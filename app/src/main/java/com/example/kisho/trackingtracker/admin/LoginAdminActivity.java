package com.example.kisho.trackingtracker.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kisho.trackingtracker.R;
import com.example.kisho.trackingtracker.user.FlagingMainActivity;
import com.example.kisho.trackingtracker.user.HomeUserActivity;
import com.example.kisho.trackingtracker.user.LoginUserActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAdminActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase
            .getInstance().getReferenceFromUrl("https://trackingtracker-3a12f-default-rtdb.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        final TextInputEditText username=findViewById(R.id.editTextadminUsername);
        final TextInputEditText password=findViewById(R.id.editTextadminPassword);

        final Button login=findViewById(R.id.buttonAdminLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernametxt=username.getText().toString();
                final String passwordtxt=password.getText().toString();

                if (usernametxt.isEmpty()||passwordtxt.isEmpty()){
                    Toast.makeText(LoginAdminActivity.this, "Fill all values", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("adminDetails").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(usernametxt)){
                                final String getpassword=snapshot.child(usernametxt).child("password").getValue(String.class);
                                if (getpassword.equals(passwordtxt)){
                                    Toast.makeText(LoginAdminActivity.this, "Suess", Toast.LENGTH_SHORT).show();
                                    Intent Logintohome= new Intent(LoginAdminActivity.this, HomeAdminActivity.class);
                                    startActivity(Logintohome);

                                }
                            }
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