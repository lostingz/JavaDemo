/**
 * Chsi
 * Created on 2015年11月23日
 */
package com.thread.test.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    private static final int POOL_SIZE = 10;

    static class CalculateThread implements Callable<Double> {
        private List<Double> dataList = new ArrayList<Double>();

        public CalculateThread() {
            for (int i = 0; i < 1000000; i++) {
                dataList.add(Math.random() * Math.sqrt(Math.random()));
            }
        }

        public Double call() throws Exception {
            double total = 0;
            for (Double data : dataList) {
                total += data;
            }
            return total / dataList.size();
        }
    }

    public static void main(String[] args) {
        List<Future<Double>> fList = new ArrayList<Future<Double>>();
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            fList.add(executor.submit(new CalculateThread()));
        }
        for (Future<Double> future : fList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
