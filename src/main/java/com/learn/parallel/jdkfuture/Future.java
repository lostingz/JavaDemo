package com.learn.parallel.jdkfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Future {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> realData=new RealData("name");
        FutureTask<String> future=new FutureTask<String>(realData);
        ExecutorService executor=Executors.newFixedThreadPool(1);
        executor.submit(future);
        System.out.println("请求完毕");
        try {
            //用一个sleep代替对其他业务逻辑的处理，在处理其他逻辑的时候，RealData被创建，从而充分利用了等待时间
            System.out.println("处理其他业务开始");
            Thread.sleep(2000);
            System.out.println("处理其他业务结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用真实的数据
        System.out.println(future.get());
    }
}
