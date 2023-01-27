package com.example.distributionoftasks;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAddapter extends RecyclerView.Adapter<RecycleViewAddapter.MyViewHolder> {

    String Icon, Name, Coast;

    public RecycleViewAddapter(String icon, String name, String coast) {
        Icon = icon;
        Name = name;
        Coast = coast;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemntrecycleview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(Name);
        holder.coast.setText(Coast);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;
        TextView coast;
        CardView mainCard;
        CardView iconCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.iconEl);
            name = itemView.findViewById(R.id.nameEl);
            coast = itemView.findViewById(R.id.coastEl);
            mainCard = itemView.findViewById(R.id.mainCard);
            iconCard = itemView.findViewById(R.id.iconCard);
        }
    }
}
