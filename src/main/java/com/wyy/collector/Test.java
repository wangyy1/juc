package com.wyy.collector;

import com.wyy.pc.C;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 8, 5, 2, 9, 4, 7, 6);
        list = list.stream().sorted().collect(Collectors.toList());

        System.out.println("list=" + list);

        List<Integer> list1 = Arrays.asList(1, 3, 8, 5, 2, 9, 4, 7, 6);
        Map<String, Object> collect = list1.stream()
                .collect(Collectors.toMap(integer -> integer + "", integer -> integer));

        System.out.println("map=" + collect);

    }
}
