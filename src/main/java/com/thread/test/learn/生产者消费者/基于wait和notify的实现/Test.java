/**
 * Chsi
 * Created on 2015年11月23日
 */
package com.thread.test.learn.生产者消费者.基于wait和notify的实现;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 公共常量
 * 
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
class Constants {
    public static final int MAX_BUFFER_SIZE = 10;
    public static final int NUM_OF_PRODUCER = 2;
    public static final int NUM_OF_CONSUMER = 3;
}

/**
 * 工作任务
 * 
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
class Task {
    private String id;

    public Task() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Task[" + id + "]";
    }
}

/**
 * 生产者
 * 
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
class Producer implements Runnable {

    private List<Task> buffer;

    public Producer(List<Task> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.size() >= Constants.MAX_BUFFER_SIZE) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Task task = new Task();
                buffer.add(task);
                buffer.notifyAll();
                System.out.println("Producer[" + Thread.currentThread().getName() + "] put " + task);
            }
        }
    }

}

class Consumer implements Runnable {

    private List<Task> buffer;

    public Consumer(List<Task> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Task task = buffer.remove(0);
                buffer.notifyAll();
                System.out.println("Consumer[" + Thread.currentThread().getName() + "] get " + task);
            }
        }

    }

}

public class Test {
    public static void main(String[] args) {
        List<Task> buffer = new ArrayList<Task>(Constants.MAX_BUFFER_SIZE);
        ExecutorService executor = Executors.newFixedThreadPool(Constants.NUM_OF_CONSUMER + Constants.NUM_OF_PRODUCER);
        for (int i = 0; i < Constants.NUM_OF_PRODUCER; i++) {
            executor.execute(new Producer(buffer));
        }
        for (int i = 0; i < Constants.NUM_OF_CONSUMER; i++) {
            executor.execute(new Consumer(buffer));
        }
    }
}
