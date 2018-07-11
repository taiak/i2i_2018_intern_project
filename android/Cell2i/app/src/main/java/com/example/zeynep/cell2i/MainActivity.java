package com.example.zeynep.cell2i;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    EditText edUsername;
    EditText edPassword;
    TextView txtforgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edUsername = (EditText) findViewById(R.id.editText_username);
        edPassword = (EditText) findViewById(R.id.editText_password);
        btnlogin = (Button) findViewById(R.id.btn_login);
        txtforgot = (TextView) findViewById(R.id.txt_forgot);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                if (isConnectionNetwork() == false) {
                    connectionFailed();
                } else if (!username.isEmpty() && !password.isEmpty()) {
                    LoginAsyncTask login = new LoginAsyncTask();
                    login.execute(username, password);
                    Task.getUserInfoTask textusername = new Task.getUserInfoTask();
                    textusername.execute(username);
                    Task.getUserTariffInfoTask texttariff = new Task.getUserTariffInfoTask();
                    texttariff.execute(username);


                } else if (username.isEmpty() || password.isEmpty()) {
                    emptyFailed();
                }

            }
        });


        txtforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangePassword.class);
                startActivity(intent);
            }
        });

    }

    //** login thread bsalangıc
    public class LoginAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.checkUser(dizi[0], dizi[1]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("true")) {
                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            } else {
                loginFailed();
            }
        }
    }

    //** login thread sonu
    public void loginFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Login Failed");
        builder.setMessage("Please check your phone number and password then try again");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void emptyFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Login Failed");
        builder.setMessage("Fields can not be blank");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void connectionFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Connection Failed");
        builder.setMessage("Please check your network connection and try again");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    boolean isConnectionNetwork() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED) {
            return false;
        } else {
            return true;
        }

    }
}

