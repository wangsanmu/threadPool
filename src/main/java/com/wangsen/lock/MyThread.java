package com.wangsen.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangsen
 * @data 2018/4/9 21:12
 */
public class MyThread implements Runnable{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName()+"获取到了锁"+lock.toString());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断"+lock.toString());
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了锁"+lock.toString());
        }
    }
}
