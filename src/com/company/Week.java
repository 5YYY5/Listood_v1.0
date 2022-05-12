package com.company;

import java.util.*;

public class Week {

    //Поля класса: массивы для обычных, постоянных задач; массив для самой недели
    ArrayList<Task> tasks = new ArrayList<Task>();
    public static Integer[] times = new Integer[20160];

    //попытка - не пытка)
    //Методы и конструктор класса

    //пустой конструктор
    public Week() {

    }

    //метод добавления задач
    //узнаём размер и с помощью for добавляем новые задачи к нашим основным массивам
    public boolean addTasks(ArrayList<Task> tasks) {
        for (Task i: tasks) {
            this.tasks.add(i);
        }
        return true;
    }

    //метод удаления задач
    //С помощью внутреннего метода чистим ячейки времени, потом обозначаем пустой удалённую задачу
    public boolean delTasks(Integer[] indextask) {
        for (int i : indextask) {
            tasks.get(i).delete();
            tasks.set(i, null);
        }
        return true;
    }

    //метод изменения задач
    public boolean chanTasks(ArrayList<Task> tasks) {
        int st = tasks.size();
        for (int i = 0; i < st; i++) {
            int j = tasks.get(i).index;
            this.tasks.get(j).delete();
            this.tasks.set(j, tasks.get(i));
        }
        return true;
    }

    //Для вывода и проверки
    public void out(){
        for (int i=0; i<1000; i++){
            System.out.println(times[i]);
        }
        System.out.println(Arrays.stream(times).toArray().toString());
    }

    //метод автоматической расстановки
    public boolean autoTasks() {

        return true;
    }
}
