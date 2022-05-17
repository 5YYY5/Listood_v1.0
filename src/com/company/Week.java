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
    public void addTasks(Task task) {
            tasks.add(task);
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
    public void chanTasks(Task task) {
            int id = task.id;
            tasks.get(id).delete();
            tasks.set(id, task);
    }

    //Для вывода и проверки
    public void out(){
        for (int i=0; i<50; i++){
            System.out.println(times[i]);
        }
    }

    //метод автоматической расстановки
    public boolean autoTasks(Task task) {
        ArrayList<Task> helptasks=(ArrayList<Task>)tasks.clone();
        helptasks.add(task);
        helptasks.sort(new AutoComp());
        String[] a = new String[helptasks.size()];
        for (int i=0; i<helptasks.size(); i++)
            a[i]=helptasks.get(i).name;
        System.out.println(Arrays.toString(a));
        String[] ts = new String[20];
        Integer nb=helptasks.get(0).indbegin;
        for (int i=0; i<helptasks.get(0).duration; i++)
            ts[nb+i]=helptasks.get(0).name;
        for (int j=1; j<helptasks.size(); j++){

        }
        return true;
    }
}
