package com.example.kisho.trackingtracker.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.kisho.trackingtracker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BookedActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SingleRideFragment singleRideFragment;
    GroupRideFragment groupRideFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);
        bottomNavigationView=findViewById(R.id.bottomNavigaton);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,SingleRideFragment.class,null).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menusingleRide:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,SingleRideFragment.class,null).commit();
                        return true;
                    case R.id.menuGroupRide:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentMain,GroupRideFragment.class,null).commit();

                }
                return false;
            }
        });

    }
}