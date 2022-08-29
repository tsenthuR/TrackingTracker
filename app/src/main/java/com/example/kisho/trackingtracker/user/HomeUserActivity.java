package com.example.kisho.trackingtracker.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kisho.trackingtracker.R;

public class HomeUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
    }


    public void GoTOFlaging(View view) {
    }

    public void GoTOBooking(View view) {
        Intent goToBook = new Intent(this,BookedActivity.class);
        startActivity(goToBook);
    }

    public void GoToLocking(View view) {
        Toast.makeText(this,"Your Cycle Locked",Toast.LENGTH_LONG).show();
    }

    public void GoToChat(View view) {
        Intent goToChat = new Intent(this,ChatActivity.class);
        startActivity(goToChat);
    }

    public void GoToHelp(View view) {
        Intent goToHelp= new Intent(this,helpActivity.class);
        startActivity(goToHelp);
    }

    public void GoTOAbout(View view) {
        Toast.makeText(this,"About",Toast.LENGTH_LONG).show();
    }
}