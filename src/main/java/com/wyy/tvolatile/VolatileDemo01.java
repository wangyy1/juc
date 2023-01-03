package com.wyy.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * 测试 volatile 保证可见性
 */
public class VolatileDemo01 {

    public static void main(String[] args) {
        test2();
    }

    /**
     * 测试多线程下操作同一个变量不能保证可见性,对主内存的变化是不可见的
     */
    static boolean flag = true;
    private static void test1() {

        new Thread(() -> {
            while (flag) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;

        System.out.println(flag);
    }

    /**
     * volatile 可以保证可见性
     */
     volatile static boolean flag1 = true;
    private static void test2() {

        new Thread(() -> {
            while (flag1) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag1 = false;

        System.out.println(flag1);
    }
}
