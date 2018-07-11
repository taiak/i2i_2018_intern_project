package com.example.zeynep.cell2i.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.zeynep.cell2i.R;

public class InvoicesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoices_page);
        RecyclerView rv = (RecyclerView)findViewById(R.id.invoiceslist);

        //LinearLayoutManager llm = new LinearLayoutManager(context);
        //rv.setLayoutManager(llm);


    }


}
