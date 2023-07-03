package com.wyy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {

    public static void main(String[] args) {
        System.out.println("---" + Double.toString(0));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10)
        );
        for (int i = 0; i < 13; i++) {
            int finalI = i;
            try {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("执行" + finalI);
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}
