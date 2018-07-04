package com.example.zeynep.cell2i;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        btnlogin  = (Button)findViewById(R.id.btn_login);
        txtforgot = (TextView)findViewById(R.id.txt_forgot);
        final Utility authentication = new Utility();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();

                    if (!username.isEmpty() && !password.isEmpty()) {
                        if(Utility.checkUsername(username,password)==true) {
                            Intent intent = new Intent(MainActivity.this, HomePage.class);
                            startActivity(intent);
                        }else {
                          loginFailed();

                        }
                    } else if(username.isEmpty()){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        builder.setMessage("Username is empty");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }
                    else if(password.isEmpty()){
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        builder.setMessage("Password is empty");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                        builder.show();
                    }
            }
        });


    }
    public void loginFailed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Login Failed");
        builder.setMessage("Please check your username and password");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
    }
}
