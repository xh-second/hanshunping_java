package com.formssi.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yang XinHua
 * @date 2022/4/26
 * 测试反射调用方法的性能以及优化方案
 */
public class Reflect02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //m1();
        m2();
    }

    public static void m1(){
        long start = System.currentTimeMillis();
        Cat cat = new Cat();
        for (int i = 0;i<900000;i++){
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1() 耗时: " + (end - start));
    }

    public static void m2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.formssi.question.Cat");
        Object o = clazz.newInstance();
        Method hi = clazz.getMethod("hi");
        //hi.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0;i < 900000;i++){
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时: " + (end - start));
    }
}
