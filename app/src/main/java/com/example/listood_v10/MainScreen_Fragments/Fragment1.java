package com.example.listood_v10.MainScreen_Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listood_v10.Adapters.Adapter_DayOfTheWeek;
import com.example.listood_v10.Adapters.Adapter_Reminders;
import com.example.listood_v10.Adapters.Day_Of_The_Week;
import com.example.listood_v10.Adapters.Reminders;
import com.example.listood_v10.Main_ficha.Week;
import com.example.listood_v10.R;
import com.example.listood_v10.app_1.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment1 extends Fragment{

    Button btmon, bttue, btwed, btthu, btfri, btsat, btsun;
    View rootview;
    ArrayList<Day_Of_The_Week> days = new ArrayList<Day_Of_The_Week>();
    ArrayList<Reminders> reminders = new ArrayList<Reminders>();
    Adapter_Reminders adapterem;

    public Week week1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_1, container, false);
        Context context = getContext();
        //==========================================================================================

        String USER_KEY = "User";
        DatabaseReference mDataBase = FirebaseDatabase.getInstance("https://listood-v1-0-probably-default-rtdb.firebaseio.com/").getReference(USER_KEY);
        week1 = new Week();
        mDataBase.push().setValue(week1);

//        init_for_firebase();

        //Адаптер Days======================================================================
        RecyclerView recyclerView = rootview.findViewById(R.id.list);
        setInitialDataDays();
        // создаем адаптер
        OnDayClickListener onDayClickListener = new OnDayClickListener() {
            @Override
            public void OnReminderClick(Day_Of_The_Week day) {
                Toast.makeText(getContext(), "Ok "+day.getTask(), Toast.LENGTH_SHORT).show();
            }
        };
        Adapter_DayOfTheWeek adapterdays = new Adapter_DayOfTheWeek(context, days, onDayClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapterdays);

        //Объявляю кнопки сбоку======================================================
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
        //Адаптер напоминания=======================================================================
        RecyclerView recyclerView1 = rootview.findViewById(R.id.list1);

        //Toast.makeText(getContext(), "Cнова здесь", Toast.LENGTH_SHORT).show();
        setInitialDataReminders();


        OnReminderClickListener onReminderClickListener = new OnReminderClickListener() {
            @Override
            public void OnReminderClick(Reminders rem) {
                Toast.makeText(getContext(), ""+rem.getReminder(), Toast.LENGTH_SHORT).show();
            }
        };


        adapterem = new Adapter_Reminders(context, reminders, onReminderClickListener);

        recyclerView1.setAdapter(adapterem);

        TextView remin = rootview.findViewById(R.id.textView_napominaniya);

        remin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_Read_Reminders fragment = new Fragment_Read_Reminders();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fr_main_place, fragment);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        return rootview;
    }

    public interface OnReminderClickListener {
        void OnReminderClick(Reminders reminders);
    }

    public interface OnDayClickListener {
        void OnReminderClick(Day_Of_The_Week days);
    }

    private void setInitialDataReminders(){
        ArrayList<String> arrayList = new ArrayList();
        String USER_KEY = "User";
        DatabaseReference mDataBase = FirebaseDatabase.getInstance("https://listood-v1-0-probably-default-rtdb.firebaseio.com/").getReference("reminders");


        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(reminders.size() > 0)reminders.clear();

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {

                    String st = ds.getValue(String.class);
                    assert st != null;
                    reminders.add(new Reminders(st));
                    //Toast.makeText(getContext(), ""+st, Toast.LENGTH_SHORT).show();

                }
                adapterem.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDataBase.addValueEventListener(vListener);


    }

    private void setInitialDataDays() {

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

//    public void init_for_firebase() {
//
//        String USER_KEY = "User";
//        DatabaseReference mDataBase = FirebaseDatabase.getInstance("https://listood-v1-0-probably-default-rtdb.firebaseio.com/").getReference(USER_KEY);
//        week1 = new Week();
//        mDataBase.push().setValue(week1);
//    }

    private void read_from_firebase(){


    }





}