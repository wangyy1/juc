package com.wyy.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println("===========");

        /**
         * 当添加数据超出设置的队列大小会抛出异常
         * java.lang.IllegalStateException: Queue full
         */
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        /**
         * 当队列为空时移除数据会抛出异常
         * java.util.NoSuchElementException
         */
//        System.out.println(blockingQueue.remove());

        /**
         * 检测队列第一个元素,不会移除
         * 如果队列为空会抛出异常
         * java.util.NoSuchElementException
         */
        System.out.println(blockingQueue.element());

    }

    /**
     * 不抛出异常
     */
    public static void test2() {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        /**
         * 添加数据超出设置的队列大小不抛出异常
         * alse 不抛出异常
         */
//        System.out.println(blockingQueue.offer("d"));


        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        /**
         * 如果队列为空 返回null 不抛出异常
         */
//        System.out.println(blockingQueue.poll());

        /**
         * 检测队列第一个元素
         */
        System.out.println(blockingQueue.peek());
    }


    /**
     * 阻塞（一直阻塞）
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        /**
         * 队列满了，会一直阻塞
         */
//        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

        /**
         * 队列为空时，会一直等待
         */
        System.out.println(blockingQueue.take());
    }

    /**
     * 阻塞（等待超时）
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        /**
         * 插入是如果队列满了会等待2秒
         */
        System.out.println(blockingQueue.offer("d", 2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        /**
         * 如果队列为空，等待两秒
         */
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));

    }

}
