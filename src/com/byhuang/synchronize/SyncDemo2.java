package com.byhuang.synchronize;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 17:31
 * @description TODO
 */
public class SyncDemo2 {

    public static void main(String[] args) {
        Line line = new Line();

        Train train1 = new Train(line);
        Train train2 = new Train(line);

        train1.start();
        train2.start();
    }
}

class Train extends Thread {

    Line line;

    Train(Line line) {
        this.line = line;
    }

    public void run() {
        line.print();
    }
}

class Line {

    // solution 1
    /*
    public synchronized void print() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(i);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    */
    // solution 2
    public void print() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
