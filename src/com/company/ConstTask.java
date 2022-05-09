package com.company;

import java.util.*;

public class ConstTask extends Week{

    //Поля класса: имя, длительность (количество 15 минуток), время действия (индекс 15 минутки в массиве недели), индикатор существования
    String name;
    Integer duration;
    Integer index;
    Boolean bool=true;

    //Конструктор
    ConstTask (String name, Integer duration, Integer index) {
        //Назначение полученных данных, заполнение ячеек времени
        this.duration=duration;
        this.index=index;
        this.name=name;
        for (int i=0; i<duration; i++) {
            times[index+i].add(index, true);
        }
    }

    //Удаление
    public boolean delete() {
        //Чистка памяти, указание индикатору, освобождение ячеек времени
        bool=false;
        for (int i=0; i<duration; i++) {
            times[index+i].delete();
        }
        name=null;
        index=null;
        duration=null;
        return true;
    }

//    //Изменение
//    public boolean change(String name, Integer duration, Integer index) {
//        for (int i=0; i<duration; i++) {
//            times[index+i].delete();
//        }
//        this.duration=duration;
//        this.index=index;
//        this.name=name;
//        for (int i=0; i<duration; i++) {
//            times[index+i].add(index, true);
//        }
//        return true;
//    }
}
