package com.example.listood_v10.MainScreen_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.listood_v10.R;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    ImageView im1, im2, im3, im4;
    Button button;
    ArrayList<ImageView> arrayList;
    int s = 0;
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
        im1 = im1.findViewById(R.id.imageView1);
        im2 = im2.findViewById(R.id.imageView2);
        im3 = im3.findViewById(R.id.imageView3);
        im4 = im4.findViewById(R.id.imageView4);

        arrayList = new ArrayList<>();
        arrayList.add(im1);
        arrayList.add(im2);
        arrayList.add(im3);
        arrayList.add(im4);
        button = button.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView im = (ImageView) arrayList.get(s);
                im.setVisibility(View.VISIBLE);
                s++;
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

}