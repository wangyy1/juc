package com.wyy.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread());
        new Thread(stringFutureTask).start();
        new Thread(stringFutureTask).start();
        try {
            String s = stringFutureTask.get(); // 获取Callable的返回结果
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        Thread.sleep(5000);
        return "123";
    }
}
