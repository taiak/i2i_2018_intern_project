package com.example.zeynep.cell2i;


import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class HomePage extends Activity {

    static TextView fullname,no,tariff;
    static TextView sumint, summin, sumsms;

    Button exit,invoices;
    ProgressBar usagevoice,usagesms,usagedata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        exit = (Button) findViewById(R.id.exit);
        invoices = (Button) findViewById(R.id.invoices);
        fullname = (TextView) findViewById(R.id.name);
        no = (TextView) findViewById(R.id.telno);
        tariff = (TextView) findViewById(R.id.tarife);
        fullname.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        no.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tariff.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        usagevoice =(ProgressBar) findViewById(R.id.kalandk);
        usagesms=(ProgressBar) findViewById(R.id.kalansms);
        usagedata=(ProgressBar) findViewById(R.id.kalanint);


        usagevoice.getProgressDrawable().setColorFilter(
                Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        sumint = (TextView)findViewById(R.id.toplamint);
        summin = (TextView)findViewById(R.id.toplamdk);
        sumsms = (TextView)findViewById(R.id.toplamsms);

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



