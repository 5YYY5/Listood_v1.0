package com.company;

import java.util.*;

public class Main {

    public static  Integer duration, index;
    public static String name;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	    Week week = new Week();
        ArrayList<Task> tasks= new ArrayList<Task>();
        for (int i=0; i<4; i++){
            index=in.nextInt();
            in.nextLine();
            duration=in.nextInt();
            in.nextLine();
            name=in.nextLine();
            System.out.println(index+" "+duration+" "+name);
            Task task= new Task(name, i, index, duration, index-1, index+duration+1);
            tasks.add(task);
        }
        week.addTasks(tasks);
        week.out();
        System.out.println("===========================================");
        Integer q[] = new Integer[]{0};
        week.delTasks(q);
        week.out();
        System.out.println("===========================================");
        q = new Integer[]{1};
        week.delTasks(q);
        week.out();
        System.out.println("===========================================");
        ArrayList<Task> w;
        w = new ArrayList<Task>();
        w.add(new Task("Task5",3, 3, 2, 1, 7));
        week.chanTasks(w);
        week.out();
    }
}
