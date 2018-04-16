package com.wangsen.threadPool;

import java.util.concurrent.*;

/**
 * @author wangsen
 * @data 2018/4/13 19:53
 */
public class PoolThreadInstance {

    private static final int corePoolSize =  5;

    private static final int maxnumPoolSize = 10;

    private static final long activTime = 5000;

    private static BlockingDeque blockingDeque = new LinkedBlockingDeque(3);

    private static RejectedExecutionHandler rejectedExecutionHandler =  new ThreadPoolExecutor.DiscardOldestPolicy();

    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    private static ThreadPoolExecutor threadPoolExecutor;

    public  static ThreadPoolExecutor getInstance() {
        if (threadPoolExecutor == null) {
            return new ThreadPoolExecutor(corePoolSize, maxnumPoolSize, activTime,
                    TimeUnit.SECONDS, blockingDeque, threadFactory, rejectedExecutionHandler);
        }
        return threadPoolExecutor;
    }
}
