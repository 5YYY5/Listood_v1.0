package com.company;

import java.util.Comparator;

class AutoComp implements Comparator<Task> {

    @Override
    public int compare(Task obj1, Task obj2) {
        //
        int m1 = obj1.indend-obj1.duration;
        int m2 = obj2.indend-obj2.duration;
        //
        if (m1 > m2)
            return -1;
        if (m1 < m2)
            return 1;
        else
            return 0;
    }
}
