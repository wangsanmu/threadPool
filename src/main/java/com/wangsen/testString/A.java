package com.wangsen.testString;

/**
 * @author wangsen
 * @data 2018/5/10 21:55
 * @des
 */
public class A {

    public void fun1(){
        fun2();
    }

    public void fun2(){
        System.out.println("class A");
    }
}

class B extends A {

    @Override
    public void fun1() {
        fun2();
    }

    @Override
    public void fun2() {
        System.out.println("Class B");
    }

    public static void main(String[] args) {
        A a;
        B b = new B();
        b.fun1();
        a = b;
        a.fun1();
    }
}