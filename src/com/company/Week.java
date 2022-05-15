package com.company;

import java.util.*;

public class Week {

    //Поля класса: массивы для обычных, постоянных задач; массив для самой недели
    ArrayList<Task> tasks = new ArrayList<Task>();
    public static Integer[] times = new Integer[20160];

    //пустой конструктор
    public Week() {}

    //метод добавления задач
    //С помощью for добавляем новые задачи в наш основной массив
    public boolean addTasks(ArrayList<Task> tasks) {
        for (Task i: tasks) {
            this.tasks.add(i);
        }
        return true;
    }

    //метод удаления задач
    //С помощью внутреннего метода чистим ячейки времени, потом обозначаем пустой удалённую задачу
    public boolean delTasks(Integer[] indextask) {
        for (Integer i : indextask) {
            tasks.get(i).delete();
            tasks.set(i, null);
        }
        return true;
    }

    //метод изменения задач
    //Отправляем исправленные задачи с нужным id
    public boolean chanTasks(ArrayList<Task> tasks) {
        int st = tasks.size();
        for (int i = 0; i < st; i++) {
            int id = tasks.get(i).id;
            this.tasks.get(id).delete();
            this.tasks.set(id, tasks.get(i));
        }
        return true;
    }

    //Для вывода и проверки
    public void out(){
        Object[] a=tasks.toArray();
        System.out.println(Arrays.toString(a));
        for (int i=0; i<50; i++){
            System.out.println(times[i]);
        }
    }

    //метод автоматической расстановки
    public boolean autoTasks(Task task) {
        ArrayList<Task> helptasks=(ArrayList<Task>)tasks.clone();
        helptasks.sort(new AutoComp());
        Object[] a=helptasks.toArray();
        System.out.println(Arrays.toString(a));
        return true;
    }
}
