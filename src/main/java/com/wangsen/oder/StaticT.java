package com.wangsen.oder;

/**
 * @author wangsen
 * @data 2018/5/4 0:07
 * @des
 */
public class StaticT {

    public static int i = 0;

    public  static void sum(){
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(new TestStatic()).start();
        }
    }

}
