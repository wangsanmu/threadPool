package com.wangsen.fanxing;

/**
 * @author wangsen
 * @data 2018/5/20 20:10
 * @des  类上面加泛型
 */
public class Box<T> {

    private T t ;

    public Box() {
    }

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Box<Integer> boxInterger = new Box<Integer>(new Integer(1));
        System.out.println(boxInterger.getT());
        Box<String> stringBox = new Box<String>(new String("\""+"1"+"\""));
        System.out.println(stringBox.getT());
        Box<Double> doubleBox = new Box<Double>();
        doubleBox.setT(222.2432423);
        System.out.println(doubleBox.getT());
    }
}
