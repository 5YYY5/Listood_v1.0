package com.example.listood_v10.MainScreen_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listood_v10.R;

public class Fragment4 extends Fragment {

    Button btthem, btacc, btinstr, btsett1, btsett2;
    View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_4, container, false);

        //Объявляю кнопки навигационной панели======================================================
        btthem = rootview.findViewById(R.id.btthem);
        btacc = rootview.findViewById(R.id.btacc);
        btinstr = rootview.findViewById(R.id.btinstr);
        btsett1 = rootview.findViewById(R.id.btsett1);
        btsett2 = rootview.findViewById(R.id.btsett2);
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

        return inflater.inflate(R.layout.fragment_4, container, false);
    }

}