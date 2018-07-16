package com.example.zeynep.cell2i.activity;

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

import com.example.zeynep.cell2i.R;
import com.example.zeynep.cell2i.service.ServiceManager;
import com.example.zeynep.cell2i.session.SessionInfo;


public class LoginPage extends AppCompatActivity {

    Button btnLogin;
    EditText edPhoneNumber;
    EditText edPassword;
    TextView txtForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPhoneNumber =  findViewById(R.id.editText_username);
        edPassword = findViewById(R.id.editText_password);
        btnLogin = findViewById(R.id.btn_login);
        txtForgot = findViewById(R.id.txt_forgot);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edPhoneNumber.getText().toString();
                String password = edPassword.getText().toString();

                if (isConnectionNetwork() == false) {
                    connectionFailed();
                } else if (!phoneNumber.isEmpty() && !password.isEmpty()) {
                    LoginAsyncTask login = new LoginAsyncTask();
                    login.execute(phoneNumber, password);
                } else  {
                    emptyFailed();
                }
            }
        });
        txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, ChangePasswordPage.class);
                startActivity(intent);
            }
        });
    }

    public class LoginAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.checkUser(dizi[0], dizi[1]);
        }

        @Override
        protected void onPostExecute(String s) {
            if (s.equals("true")) {
                SessionInfo.loggedUserPhoneNumber = edPhoneNumber.getText().toString();
                Intent intent = new Intent(LoginPage.this, HomePage.class);
                startActivity(intent);
            } else {
                loginFailed();
            }
        }
    }

    public void loginFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
        builder.setTitle("Login Failed");
        builder.setMessage("Please check your phone number and password then try again");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void emptyFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
        builder.setTitle("Login Failed");
        builder.setMessage("Fields can not be blank");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void connectionFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
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

