package com.wyy.pool;

import java.util.concurrent.*;

public class Demo01 {

    public static void main(String[] args) {
//        Executors.newSingleThreadExecutor(); // 单个线程
//        Executors.newFixedThreadPool(5); // 创建一个固定线程池的大小
//        Executors.newCachedThreadPool(); // 可伸缩的

        /**
         * 最大线程改如何定义
         * 1、CPU 密集型,几核，就是几，可以保持CPU的效率最高
         * 2、IO 密集型 判断程序中十分消耗IO的线程
         *
         * 拒绝策略
         * new ThreadPoolExecutor.AbortPolicy() 队列满了，还有任务进来，不处理这个任务，抛出异常
         * new ThreadPoolExecutor.CallerRunsPolicy() 调用方运行策略,谁调用的就用谁处理
         * new ThreadPoolExecutor.DiscardPolicy() 队列满了，丢掉任务，不会抛出异常
         * new ThreadPoolExecutor.DiscardOldestPolicy() 队列满了，尝试去和最早的竞争，也不会抛出异常
         */
        // 获取 CPU 的核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 0; i < 9; i++) {
            try {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread() + "ok");
                });
            } catch (RejectedExecutionException e) {
                System.out.println(e.toString());
            }
        }

        threadPoolExecutor.shutdown();
    }

}
