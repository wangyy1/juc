package com.wyy.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException
public class ListTest {
    public static void main(String[] args) {
//        List<String> strings = new ArrayList<>();
//        List<String> strings = new Vector<>();
//        List<String> strings = Collections.synchronizedList(new ArrayList<>());
        List<String> strings = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() ->{
                strings.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(strings);
            }).start();
        }
    }
}
