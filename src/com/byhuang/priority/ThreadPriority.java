package com.byhuang.priority;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 14:35
 * @description an example to show the priority of a thread in java
 */
public class ThreadPriority extends Thread {

    ThreadPriority(String name) {
        this.setName(name);
    }

    public void run() {
        System.out.println("Inside run method: " + currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadPriority thread1 = new ThreadPriority("thread1");
        ThreadPriority thread2 = new ThreadPriority("thread2");
        ThreadPriority thread3 = new ThreadPriority("thread3");

        System.out.println("thread 1 priority: " + thread1.getPriority());
        System.out.println("thread 2 priority: " + thread2.getPriority());
        System.out.println("thread 3 priority: " + thread3.getPriority());

        thread1.setPriority(2);
        thread2.setPriority(5);
        thread3.setPriority(8);

        System.out.println("=========after setting priority==========");
        System.out.println("thread 1 priority: " + thread1.getPriority());
        System.out.println("thread 2 priority: " + thread2.getPriority());
        System.out.println("thread 3 priority: " + thread3.getPriority());

        Thread thread0 = currentThread();
        thread0.setPriority(10);
        System.out.println("=========Main thread==========");
        System.out.println("main thread name: " + thread0.getName());
        System.out.println("thread 0 priority: " + thread0.getPriority());

        System.out.println("show execute order");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Thread with the higher priority will get an execution chance prior to other threads, but just higher chance");
    }

}
