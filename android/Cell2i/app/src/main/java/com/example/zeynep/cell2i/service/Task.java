package com.example.zeynep.cell2i.service;

import android.os.AsyncTask;
import android.util.Log;

import com.example.zeynep.cell2i.activity.HomePage;

/**
 * Created by rumey on 10.07.2018.
 */

public class Task {

    public static class UserInfoAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserInfo(dizi[0]);
        }
        @Override
        protected void onPostExecute(String result) {
        HomePage.onPostUserInfo(result);
        }
    }
    public static class UserTariffInfoAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.getUserTariffName(dizi[0]);
        }
        @Override
        public void onPostExecute(String result) {
           HomePage.onPostTariffInfo(result);
        }
    }


    public static class UsageInfoAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0] + dizi[1]);
            return ServiceManager.getUsageInfo(dizi[0], dizi[1]);
        }

        @Override
        protected void onPostExecute(String result) {
            HomePage.onPostUsageInfo(result);
        }
    }

    public static class UsageVoiceAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0] + dizi[1]);
            return ServiceManager.getUsageInfo(dizi[0], dizi[1]);
        }

        @Override
        protected void onPostExecute(String result) {
            HomePage.onPostVoiceUsageInfo(result);
        }
    }

    public static class UsageDataAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0] + dizi[1]);
            return ServiceManager.getUsageInfo(dizi[0], dizi[1]);
        }

        @Override
        protected void onPostExecute(String result) {
            HomePage.onPostDataUsageInfo(result);
        }
    }

}
