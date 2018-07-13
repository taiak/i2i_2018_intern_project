package com.example.zeynep.cell2i.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zeynep.cell2i.R;
import com.example.zeynep.cell2i.model.Invoices;

import java.util.List;

/**
 * Created by rumey on 11.07.2018.
 */

public class InvoicesAdapter extends RecyclerView.Adapter<InvoicesAdapter.ViewHolder> {


    List<Invoices> invoicesList;
    int itemLayout;
    ItemListener itemListener;

    public InvoicesAdapter(List<Invoices> invoicesList, int itemLayout) {
        this.invoicesList = invoicesList;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Invoices invoices = invoicesList.get(position);
        holder.bindItem(invoices);
    }

    @Override
    public int getItemCount()
    {
        return invoicesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView cardTitle;
        TextView cardCost;
        TextView cardDate;
        Invoices invoices;
         TextView txtPaid;



        public  ViewHolder(View itemView) {
            super(itemView);

            cardTitle =  itemView.findViewById(R.id.invoices_month);
            cardCost =      itemView.findViewById(R.id.cost);
            cardDate =  itemView.findViewById(R.id.date);
            txtPaid = itemView.findViewById(R.id.txtpaidinfo);
            itemView.setOnClickListener(this);


        }




        public void bindItem(Invoices invoices) {
            this.invoices = invoices;
            cardTitle.setText(invoices.getInvoices_month());
            cardCost.setText(invoices.getCost());
            cardDate.setText(invoices.getDate());
            txtPaid.setText(invoices.getPaidInfo());


        }


        @Override
            public void onClick(View v) {
                if (itemListener != null) {
                    itemListener.onItemClicked(invoices);

                }
        }
    }

    public interface ItemListener {
        void onItemClicked(Invoices invoices);
    }

    public void setItemListener(ItemListener itemListener)
    {
        this.itemListener = itemListener;
    }
}
