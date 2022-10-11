package com.byhuang.threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 15:48
 * @description TODO
 * 1. Create a task(Runnable Object) to execute
 * 2. Create Executor Pool using Executors
 * 3. Pass tasks to Executor Pool
 * 4. Shutdown the Executor Pool
 */
public class ThreadPool {

    public static final int MAX_T = 3;

    public static void main(String[] args) {

        // step 1: creating five tasks to be executed
        Task task1 = new Task("task1");
        Task task2 = new Task("task2");
        Task task3 = new Task("task3");
        Task task4 = new Task("task4");
        Task task5 = new Task("task5");

        // step 2
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // step 3
        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        pool.execute(task4);
        pool.execute(task5);

        // step 4
        pool.shutdown();
    }
}

class Task implements Runnable{
    private String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                if (i == 0) {
                    System.out.println("initial of the task: " + name + " = " + ft.format(d));
                } else {
                    System.out.println("Executing time of the task: " + name + " = " + ft.format(d));
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

