package com.formssi.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Yang XinHua
 * @date 2022/4/25
 */
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1,使用Properties 类,可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("chap_23_reflect\\src\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        //2,使用反射机制解决
        //(1) 加载类,返回Class类型的对象cls
        Class<?> clazz = Class.forName(classfullpath);
        Method hi = clazz.getMethod("hi");
        //(2)通过cls 得到你加载的类com.formssi.question.Cat的对象实例
        Object o = clazz.newInstance();
        System.out.println(hi);
        //传统写法:对象.方法,反射机制,方法.invoke(对象)
        hi.invoke(o);
        System.out.println("===================");
        Field age = clazz.getField("age");
        //传统写法,对象.成员变量.反射机制,成员变量对象.get(对象)
        Object o1 = age.get(o);
        System.out.println(o1);
        System.out.println("=====================");
        Constructor<?> constructors = clazz.getConstructor();
        System.out.println(constructors);
        Constructor<?> constructors2 = clazz.getConstructor(Integer.class);
        System.out.println(constructors2);
    }
}
