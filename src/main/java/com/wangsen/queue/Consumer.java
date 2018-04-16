package com.wangsen.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author wangsen
 * @data 2018/4/9 16:39
 */
public class Consumer implements  Runnable{

    private BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("当前消费者正在消费队列"+Thread.currentThread().getName());
//            blockingQueue.poll();
            //remove 消费抛异常
//            blockingQueue.remove();
            //take 消费阻塞
            blockingQueue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
