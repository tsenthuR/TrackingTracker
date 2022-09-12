package com.example.kisho.trackingtracker.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kisho.trackingtracker.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;

public class FlagingMainActivity extends AppCompatActivity  {
    DatabaseReference databaseReference= FirebaseDatabase
            .getInstance().getReferenceFromUrl("https://trackingtracker-3a12f-default-rtdb.firebaseio.com");

    private int availableFlagin=0;

    //implements AdapterView.OnItemSelectedListener

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flaging_main);


       final TextInputEditText address=findViewById(R.id.editTextSCurrentLocation);
        final TextInputEditText decrption=findViewById(R.id.flagingDescrption);
        final TextInputEditText rating=findViewById(R.id.flagingRating);
        final Button goMap=findViewById(R.id.buttonGoMaps);
        final Button butonaddflag=findViewById(R.id.buttonaddFlag);
        final Button buttonview=findViewById(R.id.buttonViewFlag);

        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FlagingMainActivity.this,FlagingsViewActivity.class);
                startActivity(intent);
            }
        });

        butonaddflag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String location=address.getText().toString();
                final String decrptiontxt=decrption.getText().toString();
                final String ratingtxt=rating.getText().toString();


                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        databaseReference.child("flagingDetails").child(decrptiontxt).child("flagingAddress").setValue(location);
                        databaseReference.child("flagingDetails").child(decrptiontxt).child("flagingDec").setValue(decrptiontxt);
                        databaseReference.child("flagingDetails").child(decrptiontxt).child("flagingRating").setValue(ratingtxt);

                        Toast.makeText(FlagingMainActivity.this, "suess add", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(FlagingMainActivity.this,HomeUserActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

        goMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addresstxt= address.getText().toString();

                String map="http://maps.google.co.in/maps?q="+addresstxt;
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);
            }
        });


//
//
////Seekbar
//        RatingSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                ratingText.setText("Rating :"+i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//      //spinner
//            ArrayAdapter ad
//                    = new ArrayAdapter(
//                    this,
//                    android.R.layout.simple_spinner_item,
//                    courses);
//
//
//            ad.setDropDownViewResource(
//                    android.R.layout
//                            .simple_spinner_dropdown_item);
//
//
//            spinnerType.setAdapter(ad);
//        }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
    }




}