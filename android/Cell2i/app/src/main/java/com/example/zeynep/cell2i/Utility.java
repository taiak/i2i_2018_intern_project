package com.example.zeynep.cell2i;

import android.widget.EditText;

/**
 * Created by Zeynep on 4.07.2018.
 */

public class Utility {


    public static boolean checkUsername(String username , String password){
        boolean is_valid = false;
        if(username.equals("yasir") && password.equals("yasir"))
            is_valid = true;

        return is_valid;
       }
}
