package com.company;

import java.util.*;

public class Main {

    public static  Integer duration, index, indbegin, indend;
    public static String name;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	    Week week = new Week();
        ArrayList<Task> tasks= new ArrayList<Task>();
        for (int i=0; i<3; i++){
            index=in.nextInt();
            in.nextLine();
            duration=in.nextInt();
            in.nextLine();
            name=in.nextLine();
            indbegin=in.nextInt();
            in.nextLine();
            indend=in.nextInt();
            in.nextLine();
            //System.out.println(index+" "+duration+" "+name);
            Task task= new Task(name, i, index, duration, indbegin, indend);
            tasks.add(task);
        }
//        week.addTasks(tasks);
        week.out();
//        System.out.println("Удаление===========================================");
//        Integer q[] = new Integer[]{0};
//        week.delTasks(q);
//        week.out();
//        System.out.println("Удаление===========================================");
//        q = new Integer[]{1};
//        week.delTasks(q);
//        week.out();
//        System.out.println("Изменение===========================================");
//        ArrayList<Task> w;
//        w = new ArrayList<Task>();
//        w.add(new Task("Task5",3, 3, 2, 1, 7));
//        week.chanTasks(w);
//        week.out();
//        System.out.println("Сортировка для автоматики===========================================");
//        week.autoTasks(new Task("Task6",3, 3, 2, 1, 7));
    }
}
