package com.example.zeynep.cell2i;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

            }
        });

    }
}
