package com.byhuang._volatile;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @date 2022/10/11 19:18
 * @description TODO
 */
public class VolatileDemo {

    static volatile Sum sum = new Sum();

    public static void main(String[] args) {

        SumThread s1 = new SumThread(sum);
        SumThread s2 = new SumThread(sum);
        SumThread s3 = new SumThread(sum);
        SumThread s4 = new SumThread(sum);

        s1.start();
        s2.start();
        s3.start();
        s4.start();
    }


}

class SumThread extends Thread {
    Sum sum = new Sum();

    SumThread(Sum sum) {
        this.sum = sum;
    }

    public void run() {
        sum.sum();
    }
}


class Sum {
    public void sum() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
