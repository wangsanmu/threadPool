package com.wangsen.waittest;

/**
 * @author wangsen
 * @data 2018/5/8 23:04
 * @des
 */
public class Pool {

    public int max = 0;

    public synchronized void getInter(){
        if(max >= 2){
            try {
                //生产足够多了
                this.wait();
                System.out.println(Thread.currentThread().getName()+"线程进入等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            max++;
            System.out.println(Thread.currentThread().getName()+"------------"+ max);
            this.notifyAll();
        }
    }

    //消费
    public synchronized void setInter(){
        if(max < 0){
            //消费不足了
            try {
                this.wait();
                System.out.println("消费者" + Thread.currentThread().getName() + "线程进入等待状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            max--;
            System.out.println(Thread.currentThread().getName()+"------------"+this.max);
            this.notifyAll();
        }
    }

}


class MyThread implements Runnable{

    private String name;

    private Pool pool;

    public MyThread(Pool pool,String name) {
        this.pool =  pool;
        this.name =  name;
    }

    @Override
    public void run() {
        while (true){
            pool.getInter();
        }
    }
}


class MyThreadConstom implements Runnable{

    private String name;

    private Pool pool;

    public MyThreadConstom(Pool pool,String name) {
        this.pool =  pool;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            pool.setInter();
        }
    }
}

class TestPool {

    public static void main(String[] args) {
        Pool pool = new Pool();
        new Thread(new MyThread(pool,"dsf")).start();
        new Thread(new MyThread(pool,"dsf")).start();
        new Thread(new MyThread(pool,"dsf")).start();
        new Thread(new MyThreadConstom(pool,"dsf1")).start();
        new Thread(new MyThreadConstom(pool,"dsf1")).start();
        new Thread(new MyThreadConstom(pool,"dsf1")).start();
        new Thread(new MyThreadConstom(pool,"dsf1")).start();
    }

}