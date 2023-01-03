package com.wyy.future;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<>(callable1);
        new Thread(ft1).start();

        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<>(callable2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());
        long end = System.currentTimeMillis();

        System.out.println("准备完毕时间：" + (end - start));


    }

}
