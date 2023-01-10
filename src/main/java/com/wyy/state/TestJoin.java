package com.wyy.state;

// join
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        MyJoin myJoin = new MyJoin();
        Thread thread = new Thread(myJoin);
        thread.start();
        for (int i = 0; i < 500; i++) {
            if (i == 1) {
                thread.join(); // 让thread 插队 执行完
            }
            System.out.println("main " + i);
        }
    }
}

class MyJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了 " + i);
        }
    }
}
