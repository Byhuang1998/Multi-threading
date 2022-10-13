package com.byhuang.threadPool;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/13 10:04
 * @description TODO
 */
public class CustomizeThreadPool {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(
                2, // core pool size
                5, // max pool size
                2, // keep alive time
                TimeUnit.SECONDS, // time unit
                new ArrayBlockingQueue<>(3), // blocking queue
                Executors.defaultThreadFactory(), // thread factory
                new ThreadPoolExecutor.DiscardPolicy() // rejection policy
        );

        Thread[] thread = new Thread[10];

        try {
            for (int i = 0; i < 10; i++) {
                thread[i] = new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "正在处理...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, String.valueOf(i));
            }
            Arrays.stream(thread).forEach(threadPool::execute);
        } finally {
            threadPool.shutdown();
        }
    }

}
