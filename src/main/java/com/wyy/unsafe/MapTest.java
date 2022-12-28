package com.wyy.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java.util.ConcurrentModificationException
 */
public class MapTest {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>()); // 线程安全
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(); // 线程安全
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            }, String.valueOf(i)).start();;
        }
    }

}
