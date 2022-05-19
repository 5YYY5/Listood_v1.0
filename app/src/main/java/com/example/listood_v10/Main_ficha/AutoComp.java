package com.example.listood_v10.Main_ficha;

import java.util.Comparator;

public class AutoComp implements Comparator<Task> {

    @Override
    public int compare(Task obj1, Task obj2) {
        //Используем полученную зависимость для компаратора
        int m1 = obj1.indend-obj1.duration;
        int m2 = obj2.indend-obj2.duration;
        //
        if (m1 < m2)
            return -1;
        if (m1 > m2)
            return 1;
        else
            return 0;
    }
}

