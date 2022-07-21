package com.formssi.entity;

import com.formssi.api.IA;
import com.formssi.api.IB;

/**
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age;
    String job;
    private double sal;

    //构造器

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    //私有的
    private Person(String name,int age){

    }

    //方法
    public void m1(String name,int age,double sal){

    }

    protected String m2(){
        return null;
    }

    void m3(){

    }
    private void m4(){

    }
}
