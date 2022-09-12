package com.example.kisho.trackingtracker.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.kisho.trackingtracker.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class BookedMainActivity extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase
            .getInstance().getReferenceFromUrl("https://trackingtracker-3a12f-default-rtdb.firebaseio.com");
    DatePickerDialog.OnDateSetListener setListenerstart;
    DatePickerDialog.OnDateSetListener setListenerend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_main);

        final TextInputEditText numberofBike=findViewById(R.id.editTextRideNumberOfBikes);
        final TextInputEditText rideStardte=findViewById(R.id.editTextRideStartDate);
        final TextInputEditText rideenddate=findViewById(R.id.editTextRideEndDate);
        final TextInputEditText ridenic=findViewById(R.id.editTextRideNIC);

        final Button bookcycle=findViewById(R.id.buttonRide);


        //Calendaer
        Calendar calendar= Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        rideStardte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        BookedMainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListenerstart,year,month
                        ,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListenerstart=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
                month=month+1;
                dayofMonth=dayofMonth;

                String date=dayofMonth+"/"+month+"/"+year;
                rideStardte.setText(date);

            }

        };
        rideenddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        BookedMainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListenerend,year,month
                        ,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListenerend=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
                month=month+1;
                year=year;
                dayofMonth=dayofMonth;
                String date=dayofMonth+"/"+month+"/"+year;
                rideenddate.setText(date);

            }

        };

        bookcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String numberbikestxt=numberofBike.getText().toString();
                final String startRidetxt= rideStardte.getText().toString();
                final String endRidetxt=rideenddate.getText().toString();
                final String ridenictxt=ridenic.getText().toString();

                if (numberbikestxt.isEmpty()||startRidetxt.isEmpty()||endRidetxt.isEmpty()||ridenictxt.isEmpty()){
                    Toast.makeText(BookedMainActivity.this, "Fill the all values", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("BookingDetails").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child("BookingDetails").child(ridenictxt).child("number of bikes").setValue(numberbikestxt);
                            databaseReference.child("BookingDetails").child(ridenictxt).child("Ride Start").setValue(startRidetxt);
                            databaseReference.child("BookingDetails").child(ridenictxt).child("Ride End").setValue(endRidetxt);
                            databaseReference.child("BookingDetails").child(ridenictxt).child("NIC or Passport").setValue(ridenictxt);

                            Toast.makeText(BookedMainActivity.this, "Booked Suess!!", Toast.LENGTH_SHORT).show();
                            Intent gotoHome=new Intent(BookedMainActivity.this,HomeUserActivity.class);
                            startActivity(gotoHome);



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