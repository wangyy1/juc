package com.wyy.stream;

import com.wyy.pc.C;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    public static void main(String[] args) {
//        User user1 = new User(1, "a", 21);
//        User user2 = new User(2, "a", 22);
//        User user3 = new User(3, "a", 23);
//        User user4 = new User(4, "a", 24);
//        User user5 = new User(5, "a", 25);
//
//        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
//        users.stream()
//                .filter(user -> user.getId() % 2 == 0)
//                .filter(user -> user.getAge() > 23)
//                .map(user -> {
//                    user.setName(user.getName().toUpperCase());
//                    return user;
//                })
//                .sorted((o1, o2) -> o2.getName()
//                        .compareTo(o1.getName()))
//                .limit(1)
//                .forEach(System.out::println);



        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> other = new ArrayList<>();
        other.addAll(Arrays.asList(7,8,9,10));

        ZoneId zoneId = ZoneId.systemDefault();


    }
}
