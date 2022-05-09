package com.example.listood_v10.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.listood_v10.Adapters.Adapter_DayOfTheWeek;
import com.example.listood_v10.Adapters.Adapter_Reminders;
import com.example.listood_v10.Adapters.Day_Of_The_Week;
import com.example.listood_v10.Adapters.Reminders;
import com.example.listood_v10.MainScreen_Fragments.Fragment1;
import com.example.listood_v10.MainScreen_Fragments.Fragment2;
import com.example.listood_v10.MainScreen_Fragments.Fragment3;
import com.example.listood_v10.MainScreen_Fragments.Fragment4;
import com.example.listood_v10.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Fragment fragmentmn;
    ImageButton bt1screen, bt2screen, bt3screen, bt4screen;
//    ArrayList<Day_Of_The_Week> days = new ArrayList<Day_Of_The_Week>();
//    ArrayList<Reminders> reminders = new ArrayList<Reminders>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        RecyclerView recyclerView = findViewById(R.id.list);
//        RecyclerView recyclerView1 = findViewById(R.id.list1);
        setContentView(R.layout.activity_main);
        //Объявляю кнопки навигационной панели======================================================
        bt1screen = (ImageButton) findViewById(R.id.bt1);
        bt2screen = (ImageButton) findViewById(R.id.bt2);
        bt3screen = (ImageButton) findViewById(R.id.bt3);
        bt4screen = (ImageButton) findViewById(R.id.bt4);
        //Устанавливаю кликеры для кнопок===========================================================
        bt1screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn = new Fragment1();
                setNewFragment(fragmentmn);
            }
        });
        bt2screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn = new Fragment2();
                setNewFragment(fragmentmn);
            }
        });
        bt3screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn = new Fragment3();
                setNewFragment(fragmentmn);
            }
        });
        bt4screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn = new Fragment4();
                setNewFragment(fragmentmn);
            }
        });
        //==========================================================================================
//        //Работаю с адаптерами======================================================================
//        setInitialData();
////        RecyclerView recyclerView = findViewById(R.id.list);
////        RecyclerView recyclerView1 = findViewById(R.id.list1);
//        // создаем адаптер
//        Adapter_DayOfTheWeek adapter = new Adapter_DayOfTheWeek(this, days);
//        Adapter_Reminders adapter1 = new Adapter_Reminders(this, reminders);
//        // устанавливаем для списка адаптер
////        recyclerView.setAdapter(adapter);
////        recyclerView1.setAdapter(adapter1);
    }

//    private void setInitialData() {
//
//        days.add(new Day_Of_The_Week("7:00","Task1"));
//        days.add(new Day_Of_The_Week("8:00","Task2"));
//        days.add(new Day_Of_The_Week("9:00","Task3"));
//        days.add(new Day_Of_The_Week("10:00","Task4"));
//        days.add(new Day_Of_The_Week("11:00","Task5"));
//        days.add(new Day_Of_The_Week("12:00","Task6"));
//        days.add(new Day_Of_The_Week("13:00","Task7"));
//        days.add(new Day_Of_The_Week("14:00","Task8"));
//        days.add(new Day_Of_The_Week("15:00","Task9"));
//        days.add(new Day_Of_The_Week("16:00","Task10"));
//        days.add(new Day_Of_The_Week("17:00","Task11"));
//        days.add(new Day_Of_The_Week("18:00","Task12"));
//    }

    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fr_main_place, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}