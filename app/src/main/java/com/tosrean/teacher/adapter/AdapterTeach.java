package com.tosrean.teacher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tosrean.teacher.R;

import org.myjson.JSONArray;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterTeach extends RecyclerView.Adapter<AdapterTeach.ItemHolder> {
    private Context context;
    private JSONArray array;


    public AdapterTeach(Context context, JSONArray array) {
        this.context = context;
        this.array = array;
    }
    @NonNull
    @Override
    public AdapterTeach.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_teach,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private CardView card;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
