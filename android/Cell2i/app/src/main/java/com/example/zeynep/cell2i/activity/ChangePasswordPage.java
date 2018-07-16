package com.example.zeynep.cell2i.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zeynep.cell2i.R;
import com.example.zeynep.cell2i.service.ServiceManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePasswordPage extends AppCompatActivity {
    EditText edPhonenumber, edNewpassword, edConfirmpassword;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        edPhonenumber =findViewById(R.id.phonenumber);
        edNewpassword =findViewById(R.id.newpassword);
        edConfirmpassword =findViewById(R.id.confirmpassword);
        btnDone = findViewById(R.id.donebtn);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_number = edPhonenumber.getText().toString();
                String new_password = edNewpassword.getText().toString();
                String confirm_password = edConfirmpassword.getText().toString();

                if (confirm_password.equals(new_password)) {
                    if (isValidPassword(new_password.toString())) {
                        changeUserPasswordAsyncTask user_password = new changeUserPasswordAsyncTask();
                        user_password.execute(phone_number, new_password);
                        changeConfirmed();
                    } else {
                        changeFailed();
                    }
                } else {
                    matchFailed();
                }
            }
        });
    }

    public class changeUserPasswordAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... dizi) {
            Log.d("test", "doInBackground: parametre >> " + dizi[0]);
            return ServiceManager.changeUserPassword(dizi[0], dizi[1]);
        }
        @Override
        protected void onPostExecute(String s) {
            if (s.equals("true")) {
                Intent intent = new Intent(ChangePasswordPage.this, LoginPage.class);
                startActivity(intent);
            }
        }
    }

    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[0-9])(?=.*[@#$%.]).{8,60})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void changeFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePasswordPage.this);
        builder.setMessage("Your password should be 8 character long and should contain at least one special character and number ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void changeConfirmed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePasswordPage.this);
        builder.setMessage("Password Confirmed");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void matchFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePasswordPage.this);
        builder.setMessage("Your password should match");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }
}
