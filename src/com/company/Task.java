package com.company;

import java.util.*;

public class Task extends Week{

    //Поля класса: имя, длительность (количество 15 минуток), время действия (индекс 15 минутки в массиве недели), индикатор существования
    String name;
    Integer duration, index;
    Boolean bool=true;
    Integer indbegin, indend;

    //Конструктор
//    Task (String name, Integer duration, Integer index, Integer indbegin, Integer indend) {
    Task (String name, Integer duration, Integer index) {
        //Назначение полученных данных, заполнение ячеек времени
        this.duration=duration;
        this.index=index;
        this.name=name;
//        this.indbegin=indbegin;
//        this.indend=indend;
        for (Integer i=0; i<duration; i++) {
            times[index+i]=index;
        }
    }

    //Удаление
    public boolean delete() {
        //Чистка памяти, указание индикатору, освобождение ячеек времени
        bool=false;
        for (int i=0; i<duration; i++) {
            times[index+i]=null;
        }
        name=null;
        index=null;
        duration=null;
        indend=null;
        indbegin=null;
        return true;
    }

}
