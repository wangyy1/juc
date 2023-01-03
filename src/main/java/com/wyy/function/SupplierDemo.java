package com.wyy.function;

import java.util.function.Supplier;

/**
 * Supplier 供给型接口
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "1024";
            }
        };

        System.out.println(supplier.get());
    }

}
