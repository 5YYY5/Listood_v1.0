package com.example.listood_v10.MainScreen_Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.listood_v10.Activities.MainActivity;
import com.example.listood_v10.R;
import com.example.listood_v10.app_2.MainActivity_2;

public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        Intent intent = new Intent(MainActivity_2.class, MainActivity_2.class);
//        startActivity(intent);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);

    }

}