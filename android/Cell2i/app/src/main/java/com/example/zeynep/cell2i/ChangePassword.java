package com.example.zeynep.cell2i;

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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePassword extends AppCompatActivity {
    EditText username, newpassword, confirmpassword;
    Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        username = (EditText) findViewById(R.id.username);
        newpassword = (EditText) findViewById(R.id.newpassword);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        donebtn = (Button) findViewById(R.id.donebtn);

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String new_password = newpassword.getText().toString();
                String confirm_password = confirmpassword.getText().toString();

                if (confirm_password.equals(new_password)) {
                    if (isValidPassword(new_password.toString())) {

                            changeUserPasswordAsyncTask deneme = new changeUserPasswordAsyncTask();
                            deneme.execute(user_name, new_password);
                            changeConfirmed();
                    } else {
                        changeFailed();
                    }
                }else{
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
                Intent intent = new Intent(ChangePassword.this, MainActivity.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this);
        builder.setMessage("Your password should be 8 character long and should contain at least one special character and number ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void changeConfirmed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this);
        builder.setMessage("Password Confirmed");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void matchFailed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this);
        builder.setMessage("Your password should match");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }
}
