package com.wangsen.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangsen
 * @data 2018/4/9 21:45
 */
public class MyThreadLock implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获取了锁"+lock.toString());
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁"+lock.toString());
            lock.unlock();//注意这个写在上面这行 你可能看到有误信息，其实他已经锁住了
        }
    }
}
