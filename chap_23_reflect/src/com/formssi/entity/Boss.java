package com.formssi.entity;

/**
 * @author Yang XinHua
 * @date 2022/4/26
 */
public class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    public Monster m1(){
        return new Monster();
    }

    private static String say(int n,String s,char c){
        return n + " " + s + " " + c;
    }

    public void hi(String s){
        System.out.println("hi " + s);
    }
}
