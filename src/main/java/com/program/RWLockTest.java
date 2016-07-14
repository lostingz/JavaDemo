/**
 * Chsi
 * Created on 2016年7月13日
 */
package com.program;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class RWLockTest implements Runnable {
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private ReadLock readLock = rwLock.readLock();
    private WriteLock writeLock = rwLock.writeLock();

    public void handleRead() throws InterruptedException {
        try {
            readLock.lock();
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName() + "read a value");
        } finally {
            readLock.unlock();
        }

    }

    public void handleWrite() throws InterruptedException {
        try {
            writeLock.lock();
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName() + "write a value");
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                handleWrite();
                handleRead();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new RWLockTest()).start();
        new Thread(new RWLockTest()).start();
        new Thread(new RWLockTest()).start();
        new Thread(new RWLockTest()).start();
    }

}
