package com.wangsen.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wangsen
 * @data 2018/4/13 19:55
 */
public class Test1 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = PoolThreadInstance.getInstance();
        for(int i=0;i<15;i++){
            System.out.println("当前线程数："+threadPoolExecutor.getPoolSize()+"当前队队列个数:"+threadPoolExecutor.getQueue().size());
            MyTask1 myTask1 = new MyTask1("name"+i);
            Future<Object> future = threadPoolExecutor.submit(myTask1);
//            try {
//                System.out.println(future.get().toString());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }
        threadPoolExecutor.shutdown();
    }
}
