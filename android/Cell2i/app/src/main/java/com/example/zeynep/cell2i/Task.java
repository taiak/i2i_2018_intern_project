package com.example.zeynep.cell2i;

import android.os.AsyncTask;
import android.util.Log;

import static com.example.zeynep.cell2i.HomePage.fullname;
import static com.example.zeynep.cell2i.HomePage.no;
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
                fullname.setText(s);

            }
        }
    }
    public static class getUserTariffNameTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserTariffName(dizi[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            if (s != null) {
                tariff.setText(s);

            }
        }
    }
    public static class getMsisdnTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserTariffBySubmsisdn(dizi[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            if(s != null)
                no.setText(s);

        }
    }
}
