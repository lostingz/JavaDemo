package com.demo.thread;

public class Sleep implements Runnable {

    public void run() {
        System.out.println("执行run");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Sleep s=new Sleep();
        Thread ta=new Thread(s,"A");
        ta.start();
    }

}
