package com.example.zeynep.cell2i;

import android.app.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomePage extends Activity {

    Button homepage, giftpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        homepage=(Button)findViewById(R.id.homepage);
        giftpage=(Button)findViewById(R.id.giftpage);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        giftpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new GiftFragment());
            }
        });


        }


    private void loadFragment(Fragment fragment){
            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft =fm.beginTransaction();
            ft.replace(R.id.frameLayout,fragment);
            ft.commit();
        }





    /*
    public void FragmentHomeClick(View v){
        new HomeFragment().clickMethod();

    }
    public void FragmentGiftClick(View v){
        new GiftFragment().clickMethod();
    }


    public void FragmentGiftClick(View view) {
        Fragment myfragment;
        myfragment = new Fragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_switch, myfragment);
        fragmentTransaction.commit();

    }*/



}
