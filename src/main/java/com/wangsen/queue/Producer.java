package com.wangsen.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangsen
 * @data 2018/4/9 16:39
 */
public class Producer implements  Runnable{

    private BlockingQueue blockingQueue;

    Lock lock = new ReentrantLock();


    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        if(true){
            try {
                lock.lock();
//                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName()+"得到了锁"+lock.toString());
                blockingQueue.offer("1");
                Thread.sleep(1000);
                System.out.println("当前队列数目"+blockingQueue.size());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+"释放了锁"+lock.toString());
                lock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + "获取锁失败.");
        }
    }
}
