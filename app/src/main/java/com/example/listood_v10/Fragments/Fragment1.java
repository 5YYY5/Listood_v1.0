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

public class Fragment1 extends Fragment {

    Button btmon, bttue, btwed, btthu, btfri, btsat, btsun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Объявляю кнопки навигационной панели======================================================
        btmon = btmon.findViewById(R.id.btmon);
        bttue = bttue.findViewById(R.id.bttue);
        btwed = btwed.findViewById(R.id.btwed);
        btthu = btthu.findViewById(R.id.btthu);
        btfri = btfri.findViewById(R.id.btfri);
        btsat = btsat.findViewById(R.id.btsat);
        btsun = btsun.findViewById(R.id.btsun);
        //Устанавливаю кликеры для кнопок===========================================================
        btmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bttue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btwed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btsun.setOnClickListener(new View.OnClickListener() {
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
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

}