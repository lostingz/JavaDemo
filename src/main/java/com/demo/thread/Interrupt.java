package com.demo.thread;

public class Interrupt implements Runnable{

    public void run() {
        System.out.println("执行run");
        try {
            for (int i = 0; i <10; i++) {
                System.out.println(Math.sqrt(i+Math.sqrt(i+1)));
                Thread.sleep(1000);
            }
            System.out.println("完成休眠");
        } catch (InterruptedException e) {
            System.out.println("线程被打断");
            return;
        }
        System.out.println("线程正常中止");
    }
    public static void main(String[] args) {
        Interrupt it=new Interrupt();
        Thread ta=new Thread(it, "A");
        ta.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ta.interrupt();//1200ms后打断线程
    }
    
}
