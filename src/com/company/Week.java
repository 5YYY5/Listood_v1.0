package com.company;

import java.util.*;

public class Week {

    //Поля класса: массивы для обычных, постоянных задач; массив для самой недели
    ArrayList<Task> tasks;
    ArrayList<ConstTask> constTasks;
    UnitOfTime[] times = new UnitOfTime[20160];

    //попытка - не пытка)
    //Методы и конструктор класса
    //в конструктуре устанавливаем постояннные задачи?самые первые, если они есть
    public Week(ArrayList<ConstTask> constTasks) {
        this.constTasks = constTasks;
    }

    //иначе пустой конструктор
    public Week() {
    }

    //метод добавления задач
    //узнаём размер и с помощью for добавляем новые задачи к нашим основным массивам
    public boolean addTasks(ArrayList<ConstTask> constTasks, ArrayList<Task> tasks) {
        int sct = constTasks.size();
        int st = tasks.size();
        for (int i = 0; i < sct; i++) {
            this.constTasks.add(constTasks.get(i));
        }
        for (int i = 0; i < sct; i++) {
            this.tasks.add(tasks.get(i));
        }
        return true;
    }

    //метод удаления задач
    //С помощью внутреннего метода чистим ячейки времени, потом обозначаем пустой удалённую задачу
    public boolean delTasks(Integer[] indexconst, Integer[] indextask) {
        for (int i : indexconst) {
            constTasks.get(i).delete();
            constTasks.set(i, null);
        }
        for (int i : indextask) {
            tasks.get(i).delete();
            tasks.set(i, null);
        }
        return true;
    }

    //метод изменения задач
    public boolean chanTasks(ArrayList<ConstTask> constTasks, ArrayList<Task> tasks) {
        int sct = constTasks.size();
        int st = tasks.size();
        int j;
        for (int i = 0; i < sct; i++) {
            j = constTasks.get(i).index;
            this.constTasks.get(j).delete();
            this.constTasks.set(j, constTasks.get(i));
        }
        for (int i = 0; i < st; i++) {
            j = constTasks.get(i).index;
            this.tasks.get(j).delete();
            this.tasks.set(j, tasks.get(i));
        }
        return true;
    }

    //метод автоматической расстановки
    public boolean autoTasks() {

        return true;
    }
}
