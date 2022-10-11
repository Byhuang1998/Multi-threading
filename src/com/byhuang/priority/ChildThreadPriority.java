package com.byhuang.priority;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 14:52
 * @description TODO
 */
public class ChildThreadPriority extends Thread{

    public void run() {
        System.out.println("Inside run method");
    }

    public static void main(String[] args) {


        // get Main thread
        Thread thread0 = currentThread();
        thread0.setPriority(8);
        System.out.println("main thread priority: " + currentThread().getPriority());

        // we should new a thread in this place, so that it can inherit the latest priority of main thread
        ChildThreadPriority childThread = new ChildThreadPriority();
        // child thread priority
        System.out.println("child thread priority: " + childThread.getPriority());
    }
}
