package com.wyy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

public class Test1 {

    /**
     * 1-10000=50005000
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, AtomicLong> map = new HashMap<>();

        map.put(1, new AtomicLong());
        map.put(2, new AtomicLong());
        map.put(3, new AtomicLong());

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 1000; j++) {
                int finalI = i;
                new Thread(() -> {
                    AtomicLong atomicLong = map.get(finalI);
                    System.out.println(atomicLong.incrementAndGet());
                }).start();
            }
        }


        if (Thread.activeCount() > 2) {
            Thread.yield();
        }

        Thread.sleep(1000);

        map.forEach(new BiConsumer<Integer, AtomicLong>() {
            @Override
            public void accept(Integer integer, AtomicLong atomicLong) {
                System.out.println(integer + "==>" + atomicLong.get());
            }
        });

    }
}
