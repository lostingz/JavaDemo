package com.demo.thread;

public class Hello implements Runnable{
    private String name;
    private int count=5;
    public Hello(String name){
        this.name=name;
    }
    public void run() {
        for (int i = 0; i < 7; i++) {
           if(count>0){
               System.out.println(Thread.currentThread().getName()+" count="+count--);
           }
        }
    }
    public static void main(String[] args) {
        Hello a=new Hello("A");
        Thread ta=new Thread(a,"Ta");
        Thread tb=new Thread(a,"Tb");
        System.out.println("Ta线程启动之前---》" + ta.isAlive());
        ta.start();
        System.out.println("Ta线程启动之后---》" + ta.isAlive());
        //tb.start();
        for (int i = 0; i <50; i++) {
            if(i>10){
                try{
                    ta.join();  //让ta执行完
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main 线程执行-->"+i);
        }
    }
}
