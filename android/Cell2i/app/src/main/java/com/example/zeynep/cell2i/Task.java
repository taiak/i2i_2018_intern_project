package com.example.zeynep.cell2i;

import android.os.AsyncTask;
import android.util.Log;

import static com.example.zeynep.cell2i.HomePage.fullname;
import static com.example.zeynep.cell2i.HomePage.no;
import static com.example.zeynep.cell2i.HomePage.sumint;
import static com.example.zeynep.cell2i.HomePage.summin;
import static com.example.zeynep.cell2i.HomePage.sumsms;
import static com.example.zeynep.cell2i.HomePage.tariff;

/**
 * Created by rumey on 10.07.2018.
 */

public class Task {
    public static class getUserInfoTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserInfo(dizi[0]);
        }

        @Override
        protected void onPostExecute(String s) {


            String[] userinfo = s.split("_");
            fullname.setText(userinfo[1] + " " + userinfo[2]);
            no.setText(userinfo[0]);


        }
    }

    public static class getUserTariffInfoTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserTariffName(dizi[0]);
        }

        @Override
        public void onPostExecute(String s) {
            String[] tariffinfo = s.split("_");
            tariff.setText(tariffinfo[0]);
            int data = Integer.parseInt(tariffinfo[3]);
            data = data / 1000;
            sumint.setText(tariffinfo[3] + " GB");
            summin.setText(tariffinfo[1] + " DK");
            int sms = Integer.parseInt(tariffinfo[2]);
            sumsms.setText(tariffinfo[2] + " SMS");
            HomePage.usagesms.setMax(sms);
            int usage = 2000;
            int usagesms = sms - usage;
            HomePage.usagesms.setProgress(usagesms);

        }
    }


    public static class getUsageInfoTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUsageInfo(dizi[0], dizi[1]);
        }

        @Override
        protected void onPostExecute(String s) {

            if (s != null) {
                String[] usageinfo = s.split("_");


            }
        }
    }

}
