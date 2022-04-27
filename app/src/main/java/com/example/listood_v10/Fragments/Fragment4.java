package com.example.listood_v10.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listood_v10.R;

public class Fragment4 extends Fragment {

    Button btthem, btacc, btinstr, btsett1, btsett2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Объявляю кнопки навигационной панели======================================================
        btthem = btthem.findViewById(R.id.btthem);
        btacc = btacc.findViewById(R.id.btacc);
        btinstr = btinstr.findViewById(R.id.btinstr);
        btsett1 = btsett1.findViewById(R.id.btsett1);
        btsett2 = btsett2.findViewById(R.id.btsett2);
        //Устанавливаю кликеры для кнопок===========================================================
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btinstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btsett1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btsett2.setOnClickListener(new View.OnClickListener() {
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
        return inflater.inflate(R.layout.fragment_4, container, false);
    }

}