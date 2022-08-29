package com.example.kisho.trackingtracker.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kisho.trackingtracker.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void Signup(View view) {
        Intent Logintohome= new Intent(this,HomeUserActivity.class);
        startActivity(Logintohome);
    }
}