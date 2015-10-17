package com.example.samarthvasishta.sjbitportal;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Samarth Vasishta on 9/29/2015.
 */
public class menu1_Fragment extends Fragment implements View.OnClickListener {
    Context applicationContext = MainActivity.getContextOfApplication();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.menu1_layout, container, false);
        Button button = (Button) rootview.findViewById(R.id.button);
        button.setOnClickListener(this);
        return rootview;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(applicationContext, WebViewActivity.class);
        startActivity(intent);
    }
}
