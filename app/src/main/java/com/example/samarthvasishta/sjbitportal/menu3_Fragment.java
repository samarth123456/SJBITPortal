package com.example.samarthvasishta.sjbitportal;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Samarth Vasishta on 9/29/2015.
 */
public class menu3_Fragment extends Fragment implements View.OnClickListener {
    Context applicationContext = MainActivity.getContextOfApplication();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.menu3_layout, container, false);
        Button button = (Button) rootview.findViewById(R.id.button3);
        button.setOnClickListener(this);
        return rootview;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(applicationContext, wbact.class);
        startActivity(intent);
    }
}