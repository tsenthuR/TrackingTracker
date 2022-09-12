package com.example.kisho.trackingtracker.user;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisho.trackingtracker.R;
import com.google.android.material.textfield.TextInputEditText;


public class SingleRideFragment extends Fragment {
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_ride, container, false);


    }
}