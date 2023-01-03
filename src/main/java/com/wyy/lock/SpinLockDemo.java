package com.wyy.lock;

import com.wyy.pc.A;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {

    private AtomicReference<Thread> reference = new AtomicReference<>();

    /**
     * 加锁
     */
    public void lock() {
        Thread thread = Thread.currentThread();

        // 自旋锁
        while (!reference.compareAndSet(null, thread)){

        }
        System.out.println(thread.getName() + "==> lock");
    }

    /**
     * 解锁
     */
    public void unlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "==> unlock");
        // 自旋锁
        reference.compareAndSet(thread, null);
    }

}

class Test {
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.unlock();
            }
        }, "T1").start();

        new Thread(() -> {
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLockDemo.unlock();
            }
        }, "T2").start();
    }
}
