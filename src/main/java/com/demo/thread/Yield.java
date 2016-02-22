package com.demo.thread;

public class Yield implements Runnable{
    public void run() {
        for(int i=0;i<5;++i){
            System.out.println(Thread.currentThread().getName()+"运行"+i);
            if(i==3){
                System.out.println("线程的礼让");
                Thread.currentThread().yield();
            }
        }
    }
    public static void main(String[] args) {
        Yield yield=new Yield();
        Thread ta=new Thread(yield,"A");
        Thread tb=new Thread(yield,"B");
        ta.start();
        tb.start();
    }
}
