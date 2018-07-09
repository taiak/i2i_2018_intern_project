package com.example.zeynep.cell2i;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomePage extends Activity {

    TextView fullname, no, recipe;
    Button exit;
    Button invoices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        exit = (Button) findViewById(R.id.exit);
        invoices = (Button) findViewById(R.id.invoices);
        fullname = (TextView) findViewById(R.id.name);
        no = (TextView) findViewById(R.id.telno);
        recipe = (TextView) findViewById(R.id.tarife);
        fullname.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        no.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        recipe.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentexit = new Intent(HomePage.this, MainActivity.class);
                startActivity(intentexit);
            }
        });
        invoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentinvoices = new Intent(HomePage.this, InvoicesPage.class);
                startActivity(intentinvoices);
            }
        });


    }

}
