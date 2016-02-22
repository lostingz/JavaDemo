package com.demo.thread;
public class Customer implements Runnable{
    private Info info=null;
    public Customer(Info info){
        this.info=info;
    }
    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.info.getName();
        }
    }
}
