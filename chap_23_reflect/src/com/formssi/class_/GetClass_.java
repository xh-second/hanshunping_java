package com.formssi.class_;

import com.formssi.question.Cat;

/**
 * 演示得到Class的各种方式
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class GetClass_ {

    public static void main(String[] args) throws ClassNotFoundException {
        //1,Class.forname
        Class<?> clazz1 = Class.forName("com.formssi.question.Cat");
        //2,类名.class
        Class<Cat> clazz2 = Cat.class;
        //3,实例.getClass
        Cat c = new Cat();
        Class<? extends Cat> clazz3 = c.getClass();
        //4 通过类加载器来获取类的Class对象
        ClassLoader classLoader= c.getClass().getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.formssi.question.Cat");
        System.out.println(clazz1.hashCode());
        System.out.println(clazz2.hashCode());
        System.out.println(clazz3.hashCode());
        System.out.println(clazz4.hashCode());

        //基本数据类型获取Class类对象
        Class<Integer> integerClass = int.class;
        Class<Byte> byteClass = byte.class;
        Class<Short> shortClass = short.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);
        //6基本数据类型对应的包装类,可以通过.TYPE得到Class类对象
        Class<Integer> type = Integer.TYPE;
        Class<Integer> integerClass1 = Integer.class;
        System.out.println(type);
        System.out.println(integerClass1);
    }
}
