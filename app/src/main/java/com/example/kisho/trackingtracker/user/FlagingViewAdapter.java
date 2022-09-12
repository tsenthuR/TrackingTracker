package com.example.kisho.trackingtracker.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisho.trackingtracker.R;

import java.util.List;

public class FlagingViewAdapter extends RecyclerView.Adapter<FlagingViewAdapter.MyViewholder> {
    private final List<FlagingItems> items;
    private final Context context;

    public FlagingViewAdapter(List<FlagingItems> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public FlagingViewAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlagingViewAdapter.MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.flagging_item_card,null));
    }

    @Override
    public void onBindViewHolder(@NonNull FlagingViewAdapter.MyViewholder holder, int position) {
        FlagingItems flagingItems=items.get(position);

        holder.place.setText("Flaging Place: "+flagingItems.getPlace());
        holder.decrption.setText("Flaging Descrptions :"+flagingItems.getDescrption());
        holder.rating.setText("Flaging ratting:"+flagingItems.getRating());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    static class MyViewholder extends RecyclerView.ViewHolder{

        private final TextView place,decrption,rating;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            place=itemView.findViewById(R.id.cardviewplace);
            decrption=itemView.findViewById(R.id.cardviewdescrptions);
            rating=itemView.findViewById(R.id.cardviewratindg);



        }


    }
}
