package com.wyy.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock  可重入锁
 */
public class Demo02 {


    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(() -> {
            phone.sms();
        }, "A").start();

        new Thread(() -> {
            phone.sms();
        }, "B").start();
    }

}

class Phone2 {
    Lock lock = new ReentrantLock();

    public synchronized void sms() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "sms");
            call();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void call() {
        lock.lock();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Thread.currentThread().getName() + "call");
        } finally {
            lock.unlock();
        }

    }
}
