package com.formssi.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.formssi.entity.Boss");
        Object o = clazz.newInstance();
        //调用方法一:
        Method m1 = clazz.getMethod("m1");
        Object invoke = m1.invoke(o);
        System.out.println(invoke);
        //调用方法say
        Method say = clazz.getDeclaredMethod("say",int.class,String.class,char.class);
        say.setAccessible(true);
        Object aa = say.invoke(o, 2, "aa", '2');
        System.out.println(aa);
        Method hi = clazz.getMethod("hi", String.class);
        hi.invoke(o,"xinhua");
        //调用static类方法.
        Object s = say.invoke(null, 23, "2342", 's');
        System.out.println(s);
    }
}
