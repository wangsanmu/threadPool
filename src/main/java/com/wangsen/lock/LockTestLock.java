package com.wangsen.lock;

/**
 * @author wangsen
 * @data 2018/4/9 21:45
 */
public class LockTestLock {

    public static void main(String[] args) {
        MyThreadLock myThreadLock = new MyThreadLock();

        for(int i=0;i<3;i++){
            new Thread(myThreadLock).start();
        }
//        new Thread(myThreadLock).start();
//        new Thread(myThreadLock).start();
//        new Thread(myThreadLock).start();

    }
}
