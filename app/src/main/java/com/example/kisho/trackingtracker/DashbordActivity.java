package com.example.kisho.trackingtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kisho.trackingtracker.admin.LoginAdminActivity;
import com.example.kisho.trackingtracker.user.LoginUserActivity;

public class DashbordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
    }

    public void GotoAdmin(View view) {
        Intent intent= new Intent(this, LoginAdminActivity.class);
        startActivity(intent);
    }

    public void GOtoUser(View view) {
        Intent intent= new Intent(this, LoginUserActivity.class);
        startActivity(intent);
    }
}