package com.linearbd.multisupportlanguage;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnChangeLang;

    private Locale locale;
    private Configuration configuration;
    MyPref myPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPref = new MyPref(getBaseContext());




        //myPref = new MyPref(getApplicationContext());

        locale = new Locale(myPref.getLocal());
        Locale.setDefault(locale);

        configuration  = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
        btnChangeLang = findViewById(R.id.btn_change_lang);
        btnChangeLang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        myPref.changeLocal();
        /*locale = new Locale(myPref.getLocal());
        configuration.setLocale(locale);*/

       /* getResources().updateConfiguration(configuration,
                getResources().getDisplayMetrics());*/
        recreate();


    }
}
