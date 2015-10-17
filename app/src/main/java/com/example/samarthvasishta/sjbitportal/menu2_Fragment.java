package com.example.samarthvasishta.sjbitportal;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Samarth Vasishta on 9/29/2015.
 */
public class menu2_Fragment extends Fragment implements View.OnClickListener {
    EditText mobileno, usncsn, issue;
    Spinner spinner;
    Context applicationContext = MainActivity.getContextOfApplication();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.menu2_layout, container, false);
        Button button = (Button) rootview.findViewById(R.id.button2);
        mobileno = (EditText) rootview.findViewById(R.id.editText5);
        usncsn = (EditText) rootview.findViewById(R.id.editText3);
        issue = (EditText) rootview.findViewById(R.id.editText4);
        spinner = (Spinner) rootview.findViewById(R.id.spinner);
        addListenerOnSpinnerItemSelection();
        button.setOnClickListener(this);
        return rootview;
    }

    @Override
    public void onClick(View view) {
        String mobilenumber = null, usn = null, iss = null;
        String number;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        int pos = sharedPreferences.getInt("Position",0);
        if (mobileno != null && usncsn != null && issue != null) {
            mobilenumber = mobileno.getText().toString();
            usn = usncsn.getText().toString();
            iss = issue.getText().toString();
            String message = ("From: " + usn + "\tMobile Number:" + mobilenumber + "\tIssue: " + iss);
            SmsManager sm = SmsManager.getDefault();
            switch(pos)
            {
                case 0:number="8095154818";break;
                case 1:number="8095154818";break;
                case 2:number="8095154818";break;
                case 3:number="8095154818";break;
                case 4:number="8095154818";break;
                case 5:number="8095154818";break;
                default:number="8095154818";break;
            }
            String msg = message;
            sm.sendTextMessage(number, null, msg, null, null);
        }
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }
}
