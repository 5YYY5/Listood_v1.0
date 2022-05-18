package com.company;

import java.util.*;

public class Week {

    //Поля класса: массивы для обычных, постоянных задач; массив для самой недели
    ArrayList<Task> tasks = new ArrayList<Task>();
    public static Integer[] times = new Integer[2016];

    //пустой конструктор
    public Week() {}

    //метод добавления задач
    //С помощью for добавляем новые задачи в наш основной массив
    public void addTasks(Task task) {
            tasks.add(task);
    }

    //метод удаления задач
    //С помощью внутреннего метода чистим ячейки времени, потом обозначаем пустой удалённую задачу
    public void delTasks(int indextask) {
            tasks.get(indextask).delete();
            tasks.remove(indextask);
            int tsz=tasks.size();
            for (int i=indextask; i<tsz;i++){
                tasks.get(i).id=i;
                Task curtk=tasks.get(i);
                for (int j=curtk.index; j<curtk.duration; j++){
                    times[j]=i;
                }
            }
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
            System.out.print(times[i]+" ");
        }
        System.out.println("\n\n\n");
    }

    //метод автоматической расстановки
    public void autoTasks(Task task) {
        //Клонируем задачи в вспомагательный массив и сортируем с помощью компаратора
        ArrayList<Task> helptasks=(ArrayList<Task>)tasks.clone();
        helptasks.add(task);

        String[] a = new String[helptasks.size()];
        for (int i=0; i<helptasks.size(); i++)
            a[i]=helptasks.get(i).name;
        System.out.println(Arrays.toString(a));

        helptasks.sort(new AutoComp());

        a = new String[helptasks.size()];
        for (int i=0; i<helptasks.size(); i++)
            a[i]=helptasks.get(i).name;
        System.out.println(Arrays.toString(a));

        //Проверка возможности такой растановки
        boolean flag=true; //Флаг показатель возможности
        int htsize=helptasks.size();
        int freecells;
        Task curtask;
        int befend=-1;

        for (int i=0; i<htsize; i++){
            curtask=helptasks.get(i);
            freecells=curtask.indend-curtask.duration;
            if (befend<=freecells){
                befend=Math.max(befend,curtask.indbegin)+curtask.duration;
            }else{
                flag=false;
                break;
            }
        }

        if (flag){//если расстановка возможна начинаем её создавать
            times=new Integer[2016];
            befend=-1;
            int begn;

            System.out.println(htsize);
            for (int i=0; i<htsize; i++) {
                curtask = helptasks.get(i);
                begn = Math.max(befend, curtask.indbegin);
                helptasks.get(i).id=i;
                helptasks.get(i).index=begn;
                System.out.println(begn+" "+curtask.duration);
                for (int j=begn; j<begn+curtask.duration; j++){
                    times[j]=i;
                    System.out.println(times[j]);
                }
                befend=begn+curtask.duration;
            }
            tasks= (ArrayList<Task>) helptasks.clone();
            System.out.println("Сделано");
        }else{
            System.out.println("Нельзя");
        }
    }
}
