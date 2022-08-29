package com.example.kisho.trackingtracker.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kisho.trackingtracker.R;

public class LoginUserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
    }

    public void LoginToSignup(View view) {
        Intent LoginToSignup= new Intent(this,SignupActivity.class);
        startActivity(LoginToSignup);
    }
    public void Logintohome(View view) {
        Intent Logintohome= new Intent(this,HomeUserActivity.class);
        startActivity(Logintohome);    }
}