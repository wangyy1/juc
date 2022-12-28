package com.wyy.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {

    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }

}

class Ticket2 {
    private int number = 50;

    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock(); // 加锁
//        lock.tryLock(); // 尝试获取锁
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余：" + number);
            }
        } finally {
            lock.unlock(); // 解锁
        }
    }
}