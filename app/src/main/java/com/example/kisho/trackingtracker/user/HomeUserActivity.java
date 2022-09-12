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
        Intent goToMainFlag = new Intent(this,FlagingMainActivity.class);
        startActivity(goToMainFlag);
    }

    public void GoTOBooking(View view) {
        Intent goToBook = new Intent(this,BookedMainActivity.class);
        startActivity(goToBook);
    }

    public void GoToLocking(View view) {
        Toast.makeText(this,"Your Cycle Unlocked",Toast.LENGTH_LONG).show();
    }

    public void GoToChat(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hii");
        sendIntent.setType("text/plain");
        // Put this line here
        sendIntent.setPackage("com.whatsapp");
        //
        startActivity(sendIntent);
        Toast.makeText(this,"Open Whatsapp",Toast.LENGTH_LONG).show();

    }

    public void GoToHelp(View view) {
        Intent goToHelp= new Intent(this,helpActivity.class);
        startActivity(goToHelp);
    }

    public void GoTOAbout(View view) {
        Intent goToAbout = new Intent(this,ChatActivity.class);
        startActivity(goToAbout);

    }
}