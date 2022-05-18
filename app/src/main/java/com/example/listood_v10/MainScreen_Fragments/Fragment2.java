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

    ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12, im13, im14, im15, im16, im17, im18, im19, im20, im21, im22, im23, im24;
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
        im5 = rootview.findViewById(R.id.imageView5);
        im6 = rootview.findViewById(R.id.imageView6);
        im7 = rootview.findViewById(R.id.imageView7);
        im8 = rootview.findViewById(R.id.imageView8);

        im9 = rootview.findViewById(R.id.imageView9);
        im10 = rootview.findViewById(R.id.imageView10);
        im11 = rootview.findViewById(R.id.imageView11);
        im12 = rootview.findViewById(R.id.imageView12);
        im13 = rootview.findViewById(R.id.imageView13);
        im14 = rootview.findViewById(R.id.imageView14);
        im15 = rootview.findViewById(R.id.imageView15);
        im16 = rootview.findViewById(R.id.imageView16);

        im17 = rootview.findViewById(R.id.imageView17);
        im18 = rootview.findViewById(R.id.imageView18);
        im19 = rootview.findViewById(R.id.imageView19);
        im20 = rootview.findViewById(R.id.imageView20);
        im21 = rootview.findViewById(R.id.imageView21);
        im22 = rootview.findViewById(R.id.imageView22);
        im23 = rootview.findViewById(R.id.imageView23);
        im24 = rootview.findViewById(R.id.imageView24);


        arrayList = new ArrayList<>();
        arrayList.add(im1);
        arrayList.add(im2);
        arrayList.add(im3);
        arrayList.add(im4);
        arrayList.add(im5);
        arrayList.add(im6);
        arrayList.add(im7);
        arrayList.add(im8);

        arrayList.add(im9);
        arrayList.add(im10);
        arrayList.add(im11);
        arrayList.add(im12);
        arrayList.add(im13);
        arrayList.add(im14);
        arrayList.add(im15);
        arrayList.add(im16);

        arrayList.add(im17);
        arrayList.add(im18);
        arrayList.add(im19);
        arrayList.add(im20);
        arrayList.add(im21);
        arrayList.add(im22);
        arrayList.add(im23);
        arrayList.add(im24);

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
                if (s<=23) {
                    ImageView im = (ImageView) arrayList.get(s);
                    im.setVisibility(View.VISIBLE);
                    s++;
                }
            }
        });
        //==========================================================================================

        return rootview;
    }

}