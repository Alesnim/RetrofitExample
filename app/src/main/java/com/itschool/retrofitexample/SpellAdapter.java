package com.itschool.retrofitexample;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itschool.retrofitexample.models.Result;


import java.util.ArrayList;
import java.util.List;

public class SpellAdapter extends RecyclerView.Adapter<SpellAdapter.SpellsViewHolder> {
    private List<Result> spellsList;


    public static class SpellsViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;

        public SpellsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_spell);
            desc = itemView.findViewById(R.id.desc);
        }
    }

    public SpellAdapter(ArrayList<Result> spells) {
        spellsList = spells;
    }

    @NonNull
    @Override
    public SpellsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.spells_element, parent, false);
        return new SpellsViewHolder(v);

    }


    @Override
    public void onBindViewHolder(@NonNull SpellsViewHolder holder, int position) {
        Result current = spellsList.get(position);
        holder.name.setText(current.getName());
        holder.desc.setText(current.getUrl());
    }




    @Override
    public int getItemCount() {
        if (spellsList == null)
            return 0;
        return spellsList.size();
    }
}
