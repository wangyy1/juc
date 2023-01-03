package com.wyy.lock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MyRunnable(lockA, lockB), "T1").start();
        new Thread(new MyRunnable(lockB, lockA), "T2").start();
    }
}


class MyRunnable implements Runnable {

    private String lockA;

    private String lockB;

    public MyRunnable(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " 1lock:" + lockA + "==>get" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 2lock:" + lockB + "==>get" + lockA);
            }

        }
    }
}