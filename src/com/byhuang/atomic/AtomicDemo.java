package com.byhuang.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 19:47
 * @description TODO
 */
public class AtomicDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                counter.add();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                counter.add();
            }
        }, "t2");

        t1.start();
        t2.start();

        // to ensure main thread can show the correct result after the operation
        t1.join();
        t2.join();

        System.out.println(counter.count);
    }

}

class Counter {

    AtomicInteger count = new AtomicInteger();

    public void add() {
        count.incrementAndGet();
    }
}

