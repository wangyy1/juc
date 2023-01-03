package com.wyy.function;

import java.util.function.Function;

/**
 * Function 函数时接口
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer + "--";
            }
        };
        System.out.println(function.apply(11));
    }
}
