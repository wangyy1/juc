package com.wyy.state;

/**
 * Thread.interrupted()
 * 如果线程处于被阻塞状态（例如处于sleep, wait, join 等状态），那么线程将立即退出被阻塞状态，并抛出一个InterruptedException异常（就是唤醒阻塞线程，阻塞线程被唤醒后，检测到中断标志位被设置了，抛出异常）。
 */
public class TestInterrupt implements Runnable {

    @Override
    public void run() {
        System.out.println("进入线程");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出线程");
    }


    public static void main(String[] args) throws InterruptedException {
        TestInterrupt testStop = new TestInterrupt();
        Thread thread = new Thread(testStop);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("线程中断了");
    }

}
