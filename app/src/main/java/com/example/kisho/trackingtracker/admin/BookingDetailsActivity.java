package com.example.kisho.trackingtracker.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kisho.trackingtracker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookingDetailsActivity extends AppCompatActivity {
    private final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

    private final List<BookingItems> bookingItemsList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        final RecyclerView recyclerView=findViewById(R.id.recyerviewBookingadmin);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(BookingDetailsActivity.this));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookingItemsList.clear();
                for(DataSnapshot booked:snapshot.child("BookingDetails").getChildren()){
                    final String getstartdate=booked.child("Ride Start").getValue(String.class);
                    final String getenddate=booked.child("Ride End").getValue(String.class);
                    final String getnumber=booked.child("number of bikes").getValue(String.class);
                    final String getnic=booked.child("NIC or Passport").getValue(String.class);

                    BookingItems bookingItems=new BookingItems(getenddate,getstartdate,getnumber,getnic);
                    bookingItemsList.add(bookingItems);


                }

                recyclerView.setAdapter(new BookinViewAdapter(bookingItemsList,BookingDetailsActivity.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}