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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }


    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fr_main_place, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}