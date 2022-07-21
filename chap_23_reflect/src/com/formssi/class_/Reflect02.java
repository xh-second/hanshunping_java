package com.formssi.class_;

import java.lang.reflect.Field;

/**
 * 演示Class类的常用方法
 *
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class Reflect02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classPath = "com.formssi.question.Cat";
        Class<?> clazz = Class.forName(classPath);
        System.out.println(clazz);
        //输出Clazz的类型
        System.out.println(clazz.getClass());
        //得到包名
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
        //得到全类名
        String name = clazz.getName();
        System.out.println(name);
        //通过cls创建对象实例
        Object o = clazz.newInstance();
        //通过反射获取属性
        Field age = clazz.getField("age");
        //获取age的值
        Object o1 = age.get(o);
        System.out.println(o1);
        //给属性赋值
        age.set(o,234);
        System.out.println(age.get(o));

    }

}
