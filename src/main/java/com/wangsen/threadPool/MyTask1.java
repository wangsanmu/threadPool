package com.wangsen.threadPool;

import java.util.concurrent.Callable;

/**
 * @author wangsen
 * @data 2018/4/13 10:45
 */
public class MyTask1 implements Callable<Object>{

    private String name;

    public MyTask1(String s) {
        this.name = s;
    }

    @Override
    public Object call() throws Exception {
        //业务执行
        Thread.sleep(3000);
        System.out.println(name+"执行完毕！！");
        return name;
    }
}
