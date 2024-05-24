package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class recyclerviewadapter extends RecyclerView.Adapter<recyclerviewadapter.MyViewHolder> {
    Context context;
    ArrayList <Lizards> lizards;
    public recyclerviewadapter(Context context, ArrayList<Lizards> lizards){
        this.context =context;
        this.lizards = lizards;
    }
    @NonNull
    @Override
    public recyclerviewadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recyclerviewitem, parent, false);

        return new recyclerviewadapter.MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerviewadapter.MyViewHolder holder, int position) {
        holder.textviewName.setText(lizards.get(position).getName()+" | ");
        holder.textviewLocation.setText(lizards.get(position).getLocation());
        holder.textviewCategory.setText(lizards.get(position).getCategory()+" | ");
    }

    @Override
    public int getItemCount() {
        return lizards.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textviewName;
        TextView textviewLocation;
        TextView textviewCategory;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textviewName = itemView.findViewById(R.id.name);
            textviewLocation = itemView.findViewById(R.id.location);
            textviewCategory = itemView.findViewById(R.id.category);
        }
    }
}