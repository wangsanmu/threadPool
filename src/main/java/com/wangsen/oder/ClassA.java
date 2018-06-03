package com.wangsen.oder;

/**
 * @author wangsen
 * @data 2018/5/7 21:28
 * @des
 */
public class ClassA {

    static {
        System.out.println("Static ClassA");
    }

    {
        System.out.println("not static ClassA");
    }

    public ClassA() {
        System.out.println("Class A");
    }
    public void print(){
        System.out.println("printA");
    }
}

class ClassB extends  ClassA{

    static {
        System.out.println("static ClassB");
    }

    {
        System.out.println("not static ClassB");
    }

    public ClassB() {
        System.out.println("Class B");
    }

    @Override
    public void print() {
        System.out.println("printB");
    }
}

class ClassC extends ClassB{
    public ClassC() {
        System.out.println("Class C");
    }

    public static void main(String[] args) {
        ClassA classA =  new ClassC();
        classA.print();
    }
}
