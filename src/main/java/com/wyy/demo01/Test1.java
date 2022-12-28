package com.wyy.demo01;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        // 获取CPU的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
