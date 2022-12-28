package com.wyy.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * java.util.ConcurrentModificationException
 */
public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>()); // 线程安全
        Set<String> set = new CopyOnWriteArraySet<>(); // 线程安全

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            }).start();
        }
    }
}
