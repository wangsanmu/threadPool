package com.wangsen.lock;

/**
 * @author wangsen
 * @data 2018/4/9 21:13
 *
 * 这里测试lock.lockInterruptibly 这个方法 该方法可以中断等待中的线程，但是要抛出异常，所以要先抛出异常
 */
public class LockTestInterruptibly {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();


        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);

        thread2.start();
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.interrupt();
    }

}
