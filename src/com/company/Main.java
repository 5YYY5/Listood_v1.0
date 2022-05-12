package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer duration, index;
        String name;
	    Week week = new Week();
        ArrayList<Task> tasks= new ArrayList<Task>();
        for (int i=0; i<2; i++){
            index=in.nextInt();
            in.nextLine();
            duration=in.nextInt();
            in.nextLine();
            name=in.nextLine();
            System.out.println(index+" "+duration+" "+name);
            Task task= new Task(name, duration, index);
            tasks.add(task);
        }
        System.out.println(tasks.toArray().toString());
        week.addTasks(tasks);
        week.out();
    }
}
