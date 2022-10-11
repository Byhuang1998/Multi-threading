package com.byhuang.synchronize;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 16:33
 * @description TODO
 */
public class SyncDemo {

    public static void main(String[] args) {

        String hi = "hi";
        String bye = "bye";

        Sender sender = new Sender();

        ThreadSend ts1 = new ThreadSend(sender, hi); ts1.setName("ts1");
        ThreadSend ts2 = new ThreadSend(sender, bye); ts2.setName("ts2");

        ts1.start();
        ts2.start();

        try {
            ts1.join();
            ts2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadSend extends Thread {

    private final Sender sender;

    private final String msg;

    ThreadSend(Sender sender, String msg) {
        this.sender = sender;
        this.msg = msg;
    }

    public void run() {

        try {
            System.out.println("sleeping: " + currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (sender) {
            sender.send(msg);
        }
    }
}

class Sender {

    public void send(String msg) {
        System.out.println("sending message: " + msg);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("message sent: " + msg);
    }
}
