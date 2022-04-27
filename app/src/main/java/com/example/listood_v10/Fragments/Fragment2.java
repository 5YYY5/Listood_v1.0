package com.example.listood_v10.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listood_v10.R;

public class Fragment2 extends Fragment {

    Button btdist, btauto, btfriend, btstat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Объявляю кнопки навигационной панели======================================================
        btdist = btdist.findViewById(R.id.bt1);
        btauto = btauto.findViewById(R.id.bt2);
        btfriend = btfriend.findViewById(R.id.bt3);
        btstat = btstat.findViewById(R.id.bt4);
        //Устанавливаю кликеры для кнопок===========================================================
        btdist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btstat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //==========================================================================================
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

}