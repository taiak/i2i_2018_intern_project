package com.example.zeynep.cell2i;

import android.os.AsyncTask;
import android.util.Log;

import static com.example.zeynep.cell2i.HomePage.fullname;
import static com.example.zeynep.cell2i.HomePage.no;
import static com.example.zeynep.cell2i.HomePage.sumsms;
import static com.example.zeynep.cell2i.HomePage.tariff;

/**
 * Created by rumey on 10.07.2018.
 */

public class Task {
    public static class getUsernameTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUsername(dizi[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            if (s != null) {
                String[] separated = s.split("_");
                fullname.setText(separated[1] + " " + separated[2]);
                no.setText(separated[0]);

            }
        }
    }
    public static class getUserTariffInfoTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserTariffName(dizi[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            if (s != null) {
                String[] separated = s.split("_");
                tariff.setText(separated[0]);
                sumsms.setText(separated[3]);

            }
        }
    }


    public static class getUsageInfoTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserTariffName(dizi[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            if (s != null) {
                String[] separated = s.split("_");



            }
        }
    }

}
