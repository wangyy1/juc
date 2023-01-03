package com.wyy.function;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Consumer 消费型接口
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("1111");

    }


}
