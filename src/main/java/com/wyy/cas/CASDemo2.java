package com.wyy.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子引用
 */
public class CASDemo2 {


    public static void main(String[] args) {

        AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(1, 1);

        new Thread(() -> {
            System.out.println("a => 1 " + reference.getStamp());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("a => 2 " + reference.compareAndSet(1, 2, reference.getStamp(), reference.getStamp() + 1));

            System.out.println("a => 2 " + reference.getStamp());

            System.out.println("a => 3 " +reference.compareAndSet(2, 1, reference.getStamp(), reference.getStamp() + 1));

            System.out.println("a => 3 " + reference.getStamp());

        }, "A").start();

        new Thread(() -> {
            int stamp = reference.getStamp();
            System.out.println("b => 1 " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("b => 2 " + reference.compareAndSet(1, 6, stamp, stamp + 1));

            System.out.println("b => 2 " + reference.getStamp());

        }, "A").start();

    }

}
