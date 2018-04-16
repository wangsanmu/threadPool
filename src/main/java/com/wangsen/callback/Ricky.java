package com.wangsen.callback;

/**
 * @author wangsen
 * @data 2018/4/13 20:57
 */
public class Ricky implements Student {

    @Override
    public void resolveQuestion(Callback callback) {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.tallAnswer(3);
    }
}
