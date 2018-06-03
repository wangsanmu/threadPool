package com.wangsen.oder;

/**
 * @author wangsen
 * @data 2018/5/4 0:06
 * @des
 */
public class TestStatic implements Runnable{

    @Override
    public void run() {
        StaticT.sum();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
