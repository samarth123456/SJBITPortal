package com.example.samarthvasishta.sjbitportal;

/**
 * Created by Samarth Vasishta on 9/29/2015.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;

public class menu4_Fragment extends Fragment {
        Button mButton;
        EditText mEditName,mEditCode,mEditDesc;
        final String email="samarthvasishta@gmail.com";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootview = inflater.inflate(R.layout.menu4_layout,container,false);
            mButton = (Button)rootview.findViewById(R.id.button1);
            mEditName = (EditText) rootview.findViewById(R.id.editName);
            mEditCode = (EditText) rootview.findViewById(R.id.editCode);
            mEditDesc = (EditText) rootview.findViewById(R.id.editDesc);


            mButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String mail = ("From:- " + mEditName.getText().toString() + "\nDescription:- " + mEditDesc.getText().toString());
                    Intent i = new Intent(Intent.ACTION_SEND); // start the activity for sending an email
                    i.setType("vnd.android.cursor.dir/email"); //set the mime type for the Email
                    i.putExtra(android.content.Intent.EXTRA_SUBJECT, (" Error Code:- " + mEditCode.getText().toString()));
                    String[] to = {email};

                    i.putExtra(android.content.Intent.EXTRA_EMAIL, to);

                    i.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(mail));
                    startActivity(Intent.createChooser(i, "EMAIL"));

                }});
                return rootview;
            }
    }
