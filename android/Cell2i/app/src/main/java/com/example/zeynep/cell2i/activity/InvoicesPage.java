package com.example.zeynep.cell2i.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.zeynep.cell2i.R;
import com.example.zeynep.cell2i.adapter.InvoicesAdapter;
import com.example.zeynep.cell2i.model.Invoices;
import com.example.zeynep.cell2i.service.Task;
import com.example.zeynep.cell2i.session.SessionInfo;

import java.util.ArrayList;
import java.util.List;

public class InvoicesPage extends AppCompatActivity {

    static  RecyclerView recyclerView;
    static InvoicesAdapter invoicesAdapter;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoices_page);
        recyclerView = findViewById(R.id.invoiceslist);
        Task.InvoiceInfoAsyncTask task = new Task.InvoiceInfoAsyncTask();
        task.execute(SessionInfo.loggedUserPhoneNumber,"6");
        context = getApplicationContext();
    }
    public static void onPostInvoicesInfo(String postResult)
    {
        String[] MonthArray = {"","JANUARY","FEBRUARY", "MARCH", "APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
        List<Invoices> invoicesList = new ArrayList<>();
        String[] invoiceArray = postResult.split("@");
        for (int i = 0; i <invoiceArray.length ; i++) {
            String invoiceDetail = invoiceArray[i];
            String[] infoArray = invoiceDetail.split("_");
            Invoices invoice = new Invoices();
            invoice.setDate("Invoice Date: " +infoArray[0]);
            invoice.setCost("Cost : " +Float.valueOf(infoArray[2]));
            String[] MonthInfoArray = invoiceDetail.split("\\.");
            int MonthInfo = Integer.parseInt(MonthInfoArray[1]) ;
            invoice.setInvoices_month(MonthArray[MonthInfo ]+ " INVOICES");
            invoice.setPaid(infoArray[3]);
            if (infoArray[3].equals("1")){
               invoice.setPaidInfo("PAID");
            }
            else
               invoice.setPaidInfo("NOT PAID");
            invoicesList.add(invoice);
        }
        loadRecyleview(invoicesList);
        Log.d("TAG", "onPostInvoicesInfo: "+postResult);
    }
    public static void loadRecyleview(List<Invoices> invoicesList)
    {
        invoicesAdapter = new InvoicesAdapter(invoicesList,R.layout.card_view);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(invoicesAdapter);
    }
}
