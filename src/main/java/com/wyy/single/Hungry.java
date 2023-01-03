package com.wyy.single;

/**
 * 饿汉式
 * 程序加载时就会创建对象，可能会浪费空间
 */
public class Hungry {

    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();


    public static Hungry getInstance() {
        return HUNGRY;
    }

}
