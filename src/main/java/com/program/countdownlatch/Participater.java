/**
 * Chsi
 * Created on 2016年7月22日
 */
package com.program.countdownlatch;


/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Participater implements Runnable {
    private String name;
    private Conference conference;

    public Participater(String name, Conference conference) {
        this.name = name;
        this.conference = conference;
    }

    @Override
    public void run() {
        conference.arrive(name);
    }
}
