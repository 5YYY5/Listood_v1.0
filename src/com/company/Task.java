package com.company;

import java.util.*;

public class Task extends Week{

    //Поля класса: имя, длительность (количество 15 минуток), время действия (индекс 15 минутки в массиве недели), индикатор существования
    String name;
    Integer duration, index, indbegin, indend, id;

    //Конструктор
    Task (String name, Integer id, Integer index, Integer duration, Integer indbegin, Integer indend) {
        //Назначение полученных данных
        this.name=name;
        this.id=id;
        this.index=index;
        this.duration=duration;
        this.indbegin=indbegin;
        this.indend=indend;
        //Заполнение ячеек времени
        for (Integer i=0; i<duration; i++) {
            times[index+i]=id;
        }
    }

    //Удаление
    public void delete() {
        //Освобождение ячеек времени
        for (Integer i=0; i<duration; i++) {
            times[index+i]=null;
        }
        //Чистка памяти
        name=null;
        id=null;
        index=null;
        duration=null;
        indend=null;
        indbegin=null;
    }
}
