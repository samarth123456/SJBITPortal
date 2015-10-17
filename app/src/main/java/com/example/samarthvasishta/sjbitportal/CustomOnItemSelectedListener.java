package com.example.samarthvasishta.sjbitportal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Karthik on 10/2/2015.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    Context applicationContext = MainActivity.getContextOfApplication();

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Log.d("Postion", String.valueOf(pos));
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        sharedPreferences.edit().putInt("Position", pos).apply();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}