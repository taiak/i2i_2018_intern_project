package com.example.zeynep.cell2i.activity;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zeynep.cell2i.R;
import com.example.zeynep.cell2i.service.Task;
import com.example.zeynep.cell2i.session.SessionInfo;


public class HomePage extends Activity {


    static TextView txtFullname, txtPhonenumber, txtTariff, txtSumdata, txtSumvoice, txtSumsms, txtUsageSms, txtUsageData, txtUsageVoice;
    Button btnExit, btnInvoices;
    static ProgressBar pBarUsagevoice, pBarUsagesms, pBarUsagedata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initalize();

        Task.UserInfoAsyncTask userInfo = new Task.UserInfoAsyncTask();
        userInfo.execute(SessionInfo.loggedUserPhoneNumber);
        Task.UserTariffInfoAsyncTask userTariff = new Task.UserTariffInfoAsyncTask();
        userTariff.execute(SessionInfo.loggedUserPhoneNumber);
        Task.UsageInfoAsyncTask usageInfo = new Task.UsageInfoAsyncTask();
        usageInfo.execute(SessionInfo.loggedUserPhoneNumber,SessionInfo.info);
        Task.UsageVoiceAsyncTask usageVoice = new Task.UsageVoiceAsyncTask();
        usageVoice.execute(SessionInfo.loggedUserPhoneNumber,SessionInfo.info1);
        Task.UsageDataAsyncTask usagedata = new Task.UsageDataAsyncTask();
        usagedata.execute(SessionInfo.loggedUserPhoneNumber,SessionInfo.info2);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentexit = new Intent(HomePage.this, LoginPage.class);
                startActivity(intentexit);
            }
        });
        btnInvoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentinvoices = new Intent(HomePage.this, InvoicesPage.class);
                startActivity(intentinvoices);
            }
        });
    }

    public void initalize()
    {
        btnExit = findViewById(R.id.exit);
        btnInvoices = findViewById(R.id.invoices);
        txtFullname = findViewById(R.id.name);
        txtPhonenumber = findViewById(R.id.telno);
        txtTariff = findViewById(R.id.tarife);
        txtUsageSms = findViewById(R.id.usagesms);
        txtUsageData = findViewById(R.id.usagedata);
        txtUsageVoice = findViewById(R.id.usagevoice);
        txtFullname.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txtPhonenumber.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txtTariff.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        pBarUsagevoice = findViewById(R.id.kalandk);
        pBarUsagesms = findViewById(R.id.kalansms);
        pBarUsagedata = findViewById(R.id.kalanint);
        txtSumdata = findViewById(R.id.toplamint);
        txtSumvoice = findViewById(R.id.toplamdk);
        txtSumsms = findViewById(R.id.toplamsms);

    }

    public static void onPostUserInfo(String postResult)
    {
        String[] infoArray = postResult.split("_");
        Log.d("TAG", "onPostUserInfo: "+postResult);
        txtFullname.setText(infoArray[1] + " " + infoArray[2]);
        txtPhonenumber.setText(infoArray[0]);
    }

    public static void onPostTariffInfo(String postResult)
    {
        String[] tariffinfo = postResult.split("_");
        txtTariff.setText(tariffinfo[0]);
        int data = Integer.parseInt(tariffinfo[3]);
        data = data / 1000;
        txtSumdata.setText(data + " GB");
        int voice = Integer.parseInt(tariffinfo[1]);
        txtSumvoice.setText(tariffinfo[1] + " DK");
        int sms = Integer.parseInt(tariffinfo[2]);
        txtSumsms.setText(tariffinfo[2] + " SMS");
        pBarUsagesms.setMax(sms);
        pBarUsagedata.setMax(data);
        pBarUsagevoice.setMax(voice);
    }

    public static void onPostUsageInfo(String postResult)
    {
        SessionInfo.loggedUserPhoneNumber = txtPhonenumber.getText().toString();
        String[] infoArray = postResult.split("_");
        Log.d("TAG", "onPostUserInfo: "+postResult);
        txtUsageSms.setText(infoArray[1]+" SMS");
        HomePage.pBarUsagesms.setProgress(Integer.parseInt(infoArray[1]));
    }

    public static void onPostVoiceUsageInfo(String postResult)
    {
        SessionInfo.loggedUserPhoneNumber = txtPhonenumber.getText().toString();
        String[] infoArray = postResult.split("_");
        Log.d("TAG", "onPostUserInfo: "+postResult);
        txtUsageVoice.setText(infoArray[1]+" DK");
        HomePage.pBarUsagevoice.setProgress(Integer.parseInt(infoArray[1]));
    }

    public static void onPostDataUsageInfo(String postResult)
    {
        SessionInfo.loggedUserPhoneNumber = txtPhonenumber.getText().toString();
        String[] infoArray = postResult.split("_");
        Log.d("TAG", "onPostUserInfo: "+postResult);
        int sumdata = Integer.valueOf(infoArray[1]);
        float usagedata = sumdata/1000;
        sumdata = sumdata/1000;
        txtUsageData.setText(usagedata+" MB");
        HomePage.pBarUsagedata.setProgress(sumdata);
    }
}



