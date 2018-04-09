package com.wangsen.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangsen
 * @data 2018/4/9 22:53
 * 测试读写操作 ReentraReadWriteLock
 * 心得:这里的Lock 更加灵活 读操作直接不会相互影响，写操作会造成影响读操作的无法进行，写写直接隔离
 */
public class TestRWLock{

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final TestRWLock testRWLock = new TestRWLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testRWLock.testReWLock(Thread.currentThread());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testRWLock.testReWLock(Thread.currentThread());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                testRWLock.testWrLock(Thread.currentThread());
            }
        }).start();

        //测试写操作
       new Thread(new Runnable() {
           @Override
           public void run() {
               testRWLock.testWrLock(Thread.currentThread());
           }
       }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                testRWLock.testReWLock(Thread.currentThread());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                testRWLock.testReWLock(Thread.currentThread());
            }
        }).start();
    }

    private void testWrLock(Thread thread) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(thread.getName()+"开始写操作"+readWriteLock.toString());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(thread.getName()+"写完毕"+readWriteLock.toString());
            readWriteLock.writeLock().unlock();

        }
    }

    private void testReWLock(Thread thread) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始读操作"+readWriteLock.toString());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"读取完毕"+readWriteLock.toString());
            readWriteLock.readLock().unlock();
        }
    }

}
