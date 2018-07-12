package com.example.zeynep.cell2i.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeynep.cell2i.model.Invoices;

import java.util.List;

/**
 * Created by rumey on 11.07.2018.
 */

public class InvoicesAdapter extends RecyclerView.Adapter<InvoicesAdapter.ViewHolder> {



    public InvoicesAdapter(List<Invoices> userList, int itemLayout) {

    }

    @NonNull
    @Override
    public InvoicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InvoicesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
