package com.example.kisho.trackingtracker.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisho.trackingtracker.R;

import java.util.List;

public class BookinViewAdapter extends RecyclerView.Adapter<BookinViewAdapter.MyViewholder> {

    private final List<BookingItems> items;
    private final Context context;

    public BookinViewAdapter(List<BookingItems> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    //BookinViewAdapter.
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.boking_details_admin,null));

    }

    @Override
    public void onBindViewHolder(@NonNull BookinViewAdapter.MyViewholder holder, int position) {
        BookingItems bookingItems=items.get(position);

        holder.nic.setText("NIC or Passport : "+bookingItems.getNic());
        holder.startdate.setText("Start Date: "+bookingItems.getStartdate());
        holder.endDate.setText("Number of bikes: "+bookingItems.getNumberofBikes());
        holder.numberbikes.setText("End Date: "+bookingItems.getEnddate());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MyViewholder extends RecyclerView.ViewHolder{

        private final TextView nic,startdate,endDate,numberbikes;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            nic=itemView.findViewById(R.id.cardviewnic);
            startdate=itemView.findViewById(R.id.cardviewstartdate);
            endDate=itemView.findViewById(R.id.cardviewEnddate);
            numberbikes=itemView.findViewById(R.id.cardviewNumberBikes);


        }


    }

}
