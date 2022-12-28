package com.wyy.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo 当所有线程执行完毕后会回调第二个参数（召唤神龙成功）
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () ->{
            System.out.println("召唤神龙成功！");
        });

        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集" + finalI + "个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            }).start();
        }
    }
}
