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
    View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_2, container, false);

        im1 = rootview.findViewById(R.id.imageView1);
        im2 = rootview.findViewById(R.id.imageView2);
        im3 = rootview.findViewById(R.id.imageView3);
        im4 = rootview.findViewById(R.id.imageView4);

        arrayList = new ArrayList<>();
        arrayList.add(im1);
        arrayList.add(im2);
        arrayList.add(im3);
        arrayList.add(im4);

        //Объявляю кнопки навигационной панели======================================================
        btdist = rootview.findViewById(R.id.btdist);
        btauto = rootview.findViewById(R.id.btauto);
        btfriend = rootview.findViewById(R.id.btfriend);
        btstat = rootview.findViewById(R.id.btstat);
        button = rootview.findViewById(R.id.button);
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView im = (ImageView) arrayList.get(s);
                im.setVisibility(View.VISIBLE);
                s++;
            }
        });
        //==========================================================================================

        return rootview;
    }

}