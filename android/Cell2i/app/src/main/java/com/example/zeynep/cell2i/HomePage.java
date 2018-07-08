package com.example.zeynep.cell2i;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class HomePage extends FragmentActivity {

    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        exit = (Button)findViewById(R.id.exit);


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentexit = new Intent(HomePage.this,MainActivity.class);
                startActivity(intentexit);
            }
        });

    }

}
