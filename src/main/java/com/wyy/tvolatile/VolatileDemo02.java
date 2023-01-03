package com.wyy.tvolatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试 volatile 不保证原子性
 */
public class VolatileDemo02 {

    // volatile 不能保证原子性
//    private  volatile static int num = 0;
    // 原子类的 Integer
    private  volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
//        num+=1; // 不是一个原子性操作
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }

}
