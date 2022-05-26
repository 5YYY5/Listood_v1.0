package com.example.listood_v10.MainScreen_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.listood_v10.R;

public class Fragment1_read extends Fragment {

    View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        rootview = inflater.inflate(R.layout.fragment_fragment1_read, container, false);


        return rootview;
    }
}