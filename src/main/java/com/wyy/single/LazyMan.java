package com.wyy.single;

import java.lang.reflect.Constructor;

/**
 * 懒汉式单利
 */
public class LazyMan {
    private LazyMan() {
        System.out.println(Thread.currentThread().getName() + " OK");
    }


    /**
     * volatile
     * 保证可见性
     * 不保证原子性
     * 不指令重排
     */
    private volatile static LazyMan lazyMan;

    /**
     * 单线程没问题，多线程会有问题
     * @return
     */
    public static LazyMan getInstance() {
        if (lazyMan == null) {
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }

    /**
     * 双重检测模式的懒汉式单利 DCL 懒汉式
     * @return
     */
    public static LazyMan getInstance2() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 10000; i++) {
//            new Thread(() -> {
//                LazyMan.getInstance2();
//            }).start();
//        }
    }

}
