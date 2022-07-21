package com.formssi.class_;

import java.io.Serializable;

/**
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> clazz1 = String.class;
        Class<Serializable> clazz2 = Serializable.class;
        Class<Integer[]> clazz3 = Integer[].class;
        Class<float[][]> clazz4 = float[][].class;
        Class<Deprecated> clazz5 = Deprecated.class;
        //枚举
        Class<Thread.State> clazz6 = Thread.State.class;
        Class<Long> clazz7 = long.class;
        Class<Void> clazz8 = void.class;
        Class<Class> clazz9 = Class.class;

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);
        System.out.println(clazz5);
        System.out.println(clazz6);
        System.out.println(clazz7);
        System.out.println(clazz8);
        System.out.println(clazz9);
    }
}
