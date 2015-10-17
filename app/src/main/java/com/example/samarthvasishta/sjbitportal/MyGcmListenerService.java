// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.samarthvasishta.sjbitportal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.android.gms.gcm.GcmListenerService;

public class MyGcmListenerService extends GcmListenerService {
    static String message1=null,message2=null,message3=null,message4=null,message5=null;
    static String subject1=null,subject2=null,subject3=null,subject4=null,subject5=null;

        private static final String TAG = "MyGcmListenerService";

        /**
         * Called when message is received.
         *
         * @param from SenderID of the sender.
         * @param data Data bundle containing message data as key/value pairs.
         *             For Set of keys use data.keySet().
         */
        // [START receive_message]
        @Override
        public void onMessageReceived(String from, Bundle data) {
            String message = data.getString("message");
            String subject = data.getString("subject");
            Log.d(TAG, "From: " + from);
            Log.d(TAG, "Message: " + message);
            Log.d(TAG, "Subject: "+subject);

            /**
             * Production applications would usually process the message here.
             * Eg: - Syncing with server.
             *     - Store message in local database.
             *     - Update UI.
             */

            /**
             * In some cases it may be useful to show a notification indicating to the user
             * that a message was received.
             */
            sendNotification(message, from,subject);
        }
        // [END receive_message]

        /**
         * Create and show a simple notification containing the received GCM message.
         *
         * @param message GCM message received.
         */
        private void sendNotification(String message, String from,String subject) {
            LocalBroadcastManager broadcaster = LocalBroadcastManager.getInstance(this);
            Intent intent = new Intent(this, NotificationActivity.class);
            intent.putExtra("from", from);
            intent.putExtra("message",message);
            intent.putExtra("subject",subject);
            SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            if(message1!=null&&message2==null&&message3==null&&message4==null&&message5==null) {
                message1 = String.valueOf(message);
                sharedpreferences.edit().putString("message1", message1).commit();
                sharedpreferences.edit().putString("subject1", subject1).commit();
            }
            else if(message1!=null&&message2!=null&&message3==null&&message4==null&&message5==null) {
                message2 = String.valueOf(message1);
                subject2 = String.valueOf(subject1);
                message1 = String.valueOf(message);
                subject1 = String.valueOf(subject);
                sharedpreferences.edit().putString("message2", message2).commit();
                sharedpreferences.edit().putString("message1", message1).commit();
                sharedpreferences.edit().putString("subject2", subject2).commit();
                sharedpreferences.edit().putString("subject1", subject1).commit();
            }
            else if(message1!=null&&message2!=null&&message3!=null&&message4==null&&message5==null) {
                message3=String.valueOf(message2);
                subject3 = String.valueOf(subject2);
                message2=String.valueOf(message1);
                subject2 = String.valueOf(subject1);
                message1 =String.valueOf(message);
                subject1 = String.valueOf(subject);
                sharedpreferences.edit().putString("message3", message3).commit();
                sharedpreferences.edit().putString("message2", message2).commit();
                sharedpreferences.edit().putString("message1", message1).commit();
                sharedpreferences.edit().putString("subject3", subject3).commit();
                sharedpreferences.edit().putString("subject2", subject2).commit();
                sharedpreferences.edit().putString("subject1", subject1).commit();
            }
            else if(message1!=null&&message2!=null&&message3!=null&&message4!=null&&message5==null) {
                message4 = String.valueOf(message3);
                subject4 = String.valueOf(subject3);
                message3 = String.valueOf(message2);
                subject3 = String.valueOf(subject2);
                message2 = String.valueOf(message1);
                subject2 = String.valueOf(subject1);
                message1 = String.valueOf(message);
                subject1 = String.valueOf(subject);
                sharedpreferences.edit().putString("message4", message4).commit();
                sharedpreferences.edit().putString("message3", message3).commit();
                sharedpreferences.edit().putString("message2", message2).commit();
                sharedpreferences.edit().putString("message1", message1).commit();
                sharedpreferences.edit().putString("subject4", subject4).commit();
                sharedpreferences.edit().putString("subject3", subject3).commit();
                sharedpreferences.edit().putString("subject2", subject2).commit();
                sharedpreferences.edit().putString("subject1", subject1).commit();

            }
            else  {
                message5= String.valueOf(message4);
                subject5 = String.valueOf(subject4);
                message4= String.valueOf(message3);
                subject4 = String.valueOf(subject3);
                message3= String.valueOf(message2);
                subject3 = String.valueOf(subject2);
                message2= String.valueOf(message1);
                subject2 = String.valueOf(subject1);
                message1 = String.valueOf(message);
                subject1 = String.valueOf(subject);
                sharedpreferences.edit().putString("message5", message5).commit();
                sharedpreferences.edit().putString("message4", message4).commit();
                sharedpreferences.edit().putString("message3", message3).commit();
                sharedpreferences.edit().putString("message2", message2).commit();
                sharedpreferences.edit().putString("message1", message1).commit();
                sharedpreferences.edit().putString("subject5", subject5).commit();
                sharedpreferences.edit().putString("subject4", subject4).commit();
                sharedpreferences.edit().putString("subject3", subject3).commit();
                sharedpreferences.edit().putString("subject2", subject2).commit();
                sharedpreferences.edit().putString("subject1", subject1).commit();
            }

            if (from.compareTo("/topics/global") == 0&&message!=null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                        PendingIntent.FLAG_ONE_SHOT);

                Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.sjb_logo)
                        .setContentTitle("New Notifications from SJBIT about")
                        .setContentText(subject)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
            }

        }
    }