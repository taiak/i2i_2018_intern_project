package com.example.zeynep.cell2i;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {
 EditText username, newpassword, confirmpassword;
 Button donebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        username = (EditText)findViewById(R.id.username);
        newpassword = (EditText)findViewById(R.id.newpassword);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);
        donebtn = (Button)findViewById(R.id.donebtn);

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String new_password = newpassword.getText().toString();
                String confirm_password = confirmpassword.getText().toString();
                 String changepassword;
                if(SubScribe.changePassword(user_name,new_password,confirm_password) == true){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this);

                    builder.setMessage("PASWORD CONFIRMED");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
                    builder.show();

                    changepassword = new_password;
                    Toast.makeText(ChangePassword.this, "Yeni şifren" + changepassword, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
