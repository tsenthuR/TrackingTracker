package com.example.kisho.trackingtracker.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kisho.trackingtracker.R;

public class HomeAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
    }

    public void GoToBookingDetails(View view) {
        Intent GoToBookingDetails= new Intent(HomeAdminActivity.this,BookingDetailsActivity.class);
        startActivity(GoToBookingDetails);
    }
}