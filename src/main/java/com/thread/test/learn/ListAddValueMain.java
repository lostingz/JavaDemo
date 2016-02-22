/**
 * Chsi
 * Created on 2015年11月23日
 */
package com.thread.test.learn;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ListAddValueMain {
    public static void main(String[] args) {
        List<Double> list = new CopyOnWriteArrayList<Double>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ListAddValueThread(list));
        executor.execute(new ListAddValueThread(list));
        executor.shutdown();
    }
}
