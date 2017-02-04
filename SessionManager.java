package com.example.dell.hackathon;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "HackPref";

    private static final String IS_LOGIN = "IsLoggedIn";


    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_UR_NUMBER = "ur_number";
    public static final String KEY_HUS_NUMBER = "hus_number";
    public static final String KEY_HUS_NAME = "hus_name";
    public static final String KEY_ID = "user_id";


    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.commit();
    }

    public void createLoginSession(String ur_name, String email) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        // Storing name in pref
        editor.putString(KEY_NAME, ur_name);
        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // commit changes
        editor.commit();
    }

    public void createUserSession(String id) {
        editor.putString(KEY_ID, id);
        editor.commit();
    }

    public void createInfo(String userno,String husname,String husno)
    {
        editor.putString(KEY_UR_NUMBER, userno);
        editor.putString(KEY_HUS_NAME, husname);
        editor.putString(KEY_HUS_NUMBER, husno);

    }



    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_UR_NUMBER, pref.getString(KEY_UR_NUMBER, null));
        user.put(KEY_HUS_NAME, pref.getString(KEY_HUS_NAME, null));
        user.put(KEY_HUS_NUMBER, pref.getString(KEY_HUS_NUMBER, null));
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        // return user
        return user;
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
/*        Intent i = new Intent(_context, MainActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
  */
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}



