package com.linearbd.multisupportlanguage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sohel on 30-01-18.
 */

public class MyPref {
    private static final String PREF_NAME="MYPref";
    private static final String BANGLA_LOCAL = "bn";
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String LOCALE = "LOCALE";

    private SharedPreferences myPref;
    private Context context;

    public MyPref(Context context) {
        this.context = context;
        myPref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }

    public String getLocal(){
        return myPref.getString(LOCALE,BANGLA_LOCAL);
    }

    public void changeLocal(){
        if(getLocal().equals(ENGLISH_LOCALE)){
            myPref.edit().putString(LOCALE,BANGLA_LOCAL).apply();
        }else {
            myPref.edit().putString(LOCALE,ENGLISH_LOCALE).apply();
        }
    }
}
