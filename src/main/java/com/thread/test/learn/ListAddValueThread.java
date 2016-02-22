/**
 * Chsi
 * Created on 2015年11月23日
 */
package com.thread.test.learn;

import java.util.List;

class ListAddValueThread implements Runnable {

    private List<Double> list;

    public ListAddValueThread(List<Double> list) {
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 20000; i++) {
            list.add(Math.random());
        }
    }
}
