package com.wangsen.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wangsen
 * @data 2018/4/9 16:37
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        //ArrayBlockingQueue 数组阻塞队列
//        BlockingQueue blockingQueue = new ArrayBlockingQueue(2);
        BlockingQueue  blockingQueue = new LinkedBlockingDeque(2);

        Producer producer = new Producer(blockingQueue);

        Consumer consumer = new Consumer(blockingQueue);


        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();


        new Thread(consumer).start();




    }
}
