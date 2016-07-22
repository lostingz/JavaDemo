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
public class ConferenceTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Conference conference = new Conference(countDownLatch);
        new Thread(conference).start();
        for (int i = 0; i < 4000; i++) {
            Participater p = new Participater("参加者" + (i + 1), conference);
            new Thread(p).start();
        }
    }
}
