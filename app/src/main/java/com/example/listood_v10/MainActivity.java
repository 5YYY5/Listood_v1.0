package com.example.listood_v10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.listood_v10.MainScreen_Fragments.Fragment1;
import com.example.listood_v10.MainScreen_Fragments.Fragment2;
import com.example.listood_v10.MainScreen_Fragments.Fragment3;
import com.example.listood_v10.MainScreen_Fragments.Fragment4;

public class MainActivity extends AppCompatActivity {

    Fragment fragmentmn;
    Button bt1screen, bt2screen, bt3screen, bt4screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Объявляю кнопки навигационной панели======================================================
        bt1screen = (Button) findViewById(R.id.bt1);
        bt2screen = (Button) findViewById(R.id.bt2);
        bt3screen = (Button) findViewById(R.id.bt3);
        bt4screen = (Button) findViewById(R.id.bt4);
        //Устанавливаю кликеры для кнопок===========================================================
        bt1screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn=new Fragment1();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fr_main_place, fragmentmn);
                ft.commit();
            }
        });
        bt2screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn=new Fragment2();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fr_main_place, fragmentmn);
                ft.commit();
            }
        });
        bt3screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn=new Fragment3();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fr_main_place, fragmentmn);
                ft.commit();
            }
        });
        bt4screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentmn=new Fragment4();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fr_main_place, fragmentmn);
                ft.commit();
            }
        });
        //==========================================================================================

    }
}