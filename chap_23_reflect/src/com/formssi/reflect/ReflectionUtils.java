package com.formssi.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_01() throws ClassNotFoundException {
        //1,得到Class对象
        Class<?> clazz = Class.forName("com.formssi.entity.Person");
        //getName 获取全类名
        String name = clazz.getName();
        System.out.println(name);
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);
        //获取所有public 修饰 的属性,包括父类
        Field[] fields = clazz.getFields();
        for (Field field:fields){
            System.out.println(field.getName());
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=");
        //获取本类的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field:declaredFields){
            System.out.println(field);
        }
        System.out.println("----------------------");
        //获取所有public 修饰的方法,包括本类和父类的
        Method[] methods = clazz.getMethods();
        for (Method method:methods){
            System.out.println(method);
        }
        System.out.println("----------------------");
        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

}
