package com.wyy.forkjoin;

import javax.naming.spi.InitialContextFactory;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1(); // 385
//        test2(); // 297
        test3(); // 297
    }

    public static void test1() {
        long sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 1; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long sum = 0;
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(1, 10_0000_0000);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

    public static void test3() {
        long sum = 0;
        long start = System.currentTimeMillis();
        sum = LongStream.rangeClosed(1, 10_0000_0000).parallel().reduce(0, new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + " 时间：" + (end - start));
    }

}
