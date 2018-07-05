package com.example.zeynep.cell2i;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

/**
 * Created by Zeynep on 4.07.2018.
 */

public class SubScribe extends Activity {

    public static boolean checkUsername(String username, String password) {

        boolean is_valid = false;
        if (!username.isEmpty() && !password.isEmpty()) {
             if (username.equals("admin") && password.equals("admin"))
                is_valid = true;

        }


            return is_valid;
    }


    public static boolean changePassword(String username, String newpassword, String confirmpassword) {

        boolean is_valid = false;

            if (username.equals("admin")  && confirmpassword.equals(newpassword)) {
                is_valid = true;

            }

        return is_valid;
    }
}
