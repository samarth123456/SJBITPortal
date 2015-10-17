package com.example.samarthvasishta.sjbitportal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Created by Karthik on 10/12/2015.
 */
public class NotificationActivity extends AppCompatActivity {
    private TextView mInformationTextView,mInformationTextView0;
    private TextView mInformationTextView00;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final String TAG = "MainActivity";
    String ErrorMessage = "Error 404 : Data NotificationActivity Found";
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.notification_main);
        ActionBar actionBar = getSupportActionBar();
        try{
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Notifications");
        }
        catch (NullPointerException e){}
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                boolean sentToken = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("sentTokenToServer", false);
                intent = getIntent();
                String message= intent.getStringExtra("message");
                String subject= intent.getStringExtra("subject");
                mInformationTextView.setVisibility(View.GONE);
                Log.d(message,subject);
                    if (sentToken) {
                        if (!message.equals(ErrorMessage)&&!subject.equals(ErrorMessage)) {
                            mInformationTextView.setVisibility(View.GONE);
                            mInformationTextView00.setVisibility(View.VISIBLE);
                            mInformationTextView0.setVisibility(View.VISIBLE);
                            mInformationTextView00.setText("Subject:- "+subject);
                            mInformationTextView0.setText("Message:- "+message);
                        } else {
                            mInformationTextView0.setVisibility(View.GONE);
                            mInformationTextView00.setVisibility(View.GONE);
                            mInformationTextView.setVisibility(View.VISIBLE);
                            mInformationTextView.setText(R.string.registering_message);
                        }
                    }

                if (!sentToken)

                {
                    mInformationTextView.setVisibility(View.VISIBLE);
                    mInformationTextView.setText(getString(R.string.token_error_message));
                }
            }
        };
        mInformationTextView = (TextView)findViewById(R.id.informationTextView);
        mInformationTextView0 = (TextView)findViewById(R.id.informationTextView0);
        mInformationTextView00 = (TextView)findViewById(R.id.informationTextView00);
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(QuickstartPreferences.REGISTRATION_COMPLETE));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == android.R.id.home)
        {
            finish();
        }
        if(menuitem.getItemId() == R.id.action_settings1)
        {
            startActivity(new Intent(this,AboutUs.class));
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
