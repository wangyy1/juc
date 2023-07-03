package com.wyy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

public class Test2 {

    /**
     * 1-10000=50005000
     * @param args
     */
    public static void main(String[] args) {
//        int a = 0;
//        for (int j = 1; j <= 10; j++) {
//            a += j;
//        }
//
//        System.out.println(a);

        AtomicLong atomicLong = new AtomicLong();
        for (int i = 1; i < 10; i++) {
            System.out.println(atomicLong.incrementAndGet());
        }
    }
}
