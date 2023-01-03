package com.wyy.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {

    static AtomicInteger atomicInteger = new AtomicInteger(2020);

    public static void main(String[] args) {
        /**
         * compareAndSet 比较并交换
         */
        // 如果我期望的值达到了，那么就更新，否则，就不更新
        atomicInteger.compareAndSet(2020, 2021);
        System.out.println(atomicInteger.get());


        atomicInteger.compareAndSet(2020, 2022);
        System.out.println(atomicInteger.get());


    }

}
