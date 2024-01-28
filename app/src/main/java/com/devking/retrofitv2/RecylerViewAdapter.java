package com.devking.retrofitv2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.View_Holder> {

    private ArrayList<retrofit_model> data;
    private ClickListner clickListner;

    public RecylerViewAdapter(ArrayList<retrofit_model> data ,ClickListner clickListner) {
        this.data = data;
        this.clickListner=clickListner;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_view_layout, parent, false);
        return new View_Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        retrofit_model currentItem = data.get(position);
        holder.id.setText(currentItem.getId());
        holder.title.setText(currentItem.getName());

    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0; // Check for null before accessing size
    }

    public class View_Holder extends RecyclerView.ViewHolder {

        TextView id, title;

        public View_Holder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            title = itemView.findViewById(R.id.body);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListner.onItemCLick(getAdapterPosition());
                }
            });

        }

    }
}
