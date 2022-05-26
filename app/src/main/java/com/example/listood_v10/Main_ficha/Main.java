package com.example.listood_v10.Main_ficha;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.*;

public class Main {



    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Week week = new Week();
        Integer duration, index, indbegin, indend;
        String name;

        for (int i = 0; i < 2; i++) {
            index = in.nextInt();
            in.nextLine();

            duration = in.nextInt();
            in.nextLine();

            name = in.nextLine();

            indbegin = in.nextInt();
            in.nextLine();

            indend = in.nextInt();
            in.nextLine();

            week.addTasks(new Task(name, i, index, duration, indbegin, indend));
        }
        System.out.print("=============Конец ввода=============\n");
        week.out();

        System.out.print("=============Удаление T3=============\n");
        week.delTasks(1);
        week.out();

        System.out.print("=============Помещаем T2 на место T3=============\n");
        week.chanTasks(new Task("из T2 в T3", 0, 7, 2, 5, 10));
        week.out();

        System.out.print("=============Создание нового T2=============\n");
        week.addTasks(new Task("новый T2", 1, 3, 2, 2, 8));
        week.out();

        System.out.print("=============Автоматическое добавление T1=============\n");
        week.autoTasks(new Task("T1", 2, 4, 3, 3, 8));
        week.out();
    }
}

