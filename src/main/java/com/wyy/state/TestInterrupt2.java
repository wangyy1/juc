package com.wyy.state;

/**
 * Thread.interrupted()
 * 如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），那么线程将立即退出被阻塞状态，并抛出一个InterruptedException异常（就是唤醒阻塞线程，阻塞线程被唤醒后，检测到中断标志位被设置了，抛出异常）。
 */
public class TestInterrupt2 implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (!Thread.interrupted()){
            System.out.println("run...Thread" + i ++);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TestInterrupt2 testStop = new TestInterrupt2();
        Thread thread = new Thread(testStop);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("线程中断了");
    }

}
