package com.demo.thread;

public class SynchronizedDemo implements Runnable {
    private int count = 5;

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                if (count > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(count--);
                }
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        Thread ta = new Thread(demo, "A");
        Thread tb = new Thread(demo, "B");
        Thread tc = new Thread(demo, "C");
        ta.start();
        tb.start();
        tc.start();
    }
}
