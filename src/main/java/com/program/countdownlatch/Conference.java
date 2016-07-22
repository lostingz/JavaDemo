/**
 * Chsi
 * Created on 2016年7月22日
 */
package com.program.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Conference implements Runnable {
    private CountDownLatch countDownLatch;

    public Conference(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void arrive(String name) {
        System.out.println(name + " is arrived");
        countDownLatch.countDown();
    }

    @Override
    public void run() {
        System.out.println("会议开始");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("人到全会议可以开始");
    }
}
