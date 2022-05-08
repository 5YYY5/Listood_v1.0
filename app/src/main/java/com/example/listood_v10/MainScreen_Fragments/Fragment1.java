package com.example.listood_v10.MainScreen_Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listood_v10.Adapters.Adapter_DayOfTheWeek;
import com.example.listood_v10.Adapters.Adapter_Reminders;
import com.example.listood_v10.Adapters.Day_Of_The_Week;
import com.example.listood_v10.Adapters.Reminders;
import com.example.listood_v10.R;

import java.util.ArrayList;

public class Fragment1 extends Fragment{

    Button btmon, bttue, btwed, btthu, btfri, btsat, btsun;
    View rootview;
    ArrayList<Day_Of_The_Week> days = new ArrayList<Day_Of_The_Week>();
    ArrayList<Reminders> reminders = new ArrayList<Reminders>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_1, container, false);

        //Объявляю кнопки навигационной панели======================================================
        btmon = rootview.findViewById(R.id.btmon);
        bttue = rootview.findViewById(R.id.bttue);
        btwed = rootview.findViewById(R.id.btwed);
        btthu = rootview.findViewById(R.id.btthu);
        btfri = rootview.findViewById(R.id.btfri);
        btsat = rootview.findViewById(R.id.btsat);
        btsun = rootview.findViewById(R.id.btsun);
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
        //Работаю с адаптерами======================================================================
        RecyclerView recyclerView = rootview.findViewById(R.id.list);
        RecyclerView recyclerView1 = rootview.findViewById(R.id.list1);
        setInitialData();
//        RecyclerView recyclerView = findViewById(R.id.list);
//        RecyclerView recyclerView1 = findViewById(R.id.list1);
        Context context = getContext();
        // создаем адаптер
        Adapter_DayOfTheWeek adapter = new Adapter_DayOfTheWeek(context, days);
        Adapter_Reminders adapter1 = new Adapter_Reminders(context, reminders);
        // устанавливаем для списка адаптер
//        recyclerView.setAdapter(adapter);
//        recyclerView1.setAdapter(adapter1);

        return rootview;
    }

    private void setInitialData() {

        days.add(new Day_Of_The_Week("7:00","Task1"));
        days.add(new Day_Of_The_Week("8:00","Task2"));
        days.add(new Day_Of_The_Week("9:00","Task3"));
        days.add(new Day_Of_The_Week("10:00","Task4"));
        days.add(new Day_Of_The_Week("11:00","Task5"));
        days.add(new Day_Of_The_Week("12:00","Task6"));
        days.add(new Day_Of_The_Week("13:00","Task7"));
        days.add(new Day_Of_The_Week("14:00","Task8"));
        days.add(new Day_Of_The_Week("15:00","Task9"));
        days.add(new Day_Of_The_Week("16:00","Task10"));
        days.add(new Day_Of_The_Week("17:00","Task11"));
        days.add(new Day_Of_The_Week("18:00","Task12"));
    }

}