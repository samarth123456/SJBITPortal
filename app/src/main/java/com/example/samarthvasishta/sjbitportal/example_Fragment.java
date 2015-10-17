package com.example.samarthvasishta.sjbitportal;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Samarth Vasishta on 10/12/2015.
 */
public class example_Fragment extends Fragment {
View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.example_layout, container, false);
        return rootview;
    }
}
