package com.example.kisho.trackingtracker.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kisho.trackingtracker.R;
import com.example.kisho.trackingtracker.admin.BookinViewAdapter;
import com.example.kisho.trackingtracker.admin.BookingDetailsActivity;
import com.example.kisho.trackingtracker.admin.BookingItems;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FlagingsViewActivity extends AppCompatActivity {
    private final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

    private final List<FlagingItems> flagingItemsList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagings_view);

        final RecyclerView recyclerView=findViewById(R.id.recyerviewFlagings);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(FlagingsViewActivity.this));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                flagingItemsList.clear();
                for(DataSnapshot flaged:snapshot.child("flagingDetails").getChildren()){
                    final String getplace=flaged.child("flagingAddress").getValue(String.class);
                    final String getDecription=flaged.child("flagingDec").getValue(String.class);
                    final String getrating=flaged.child("flagingRating").getValue(String.class);

                    FlagingItems flagingItems=new FlagingItems(getplace,getDecription,getrating);
                    flagingItemsList.add(flagingItems);





                }

                recyclerView.setAdapter(new FlagingViewAdapter( flagingItemsList,FlagingsViewActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}