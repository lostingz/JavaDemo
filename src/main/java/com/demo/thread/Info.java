package com.demo.thread;

public class Info{
    private String name="test";
    private String age="0";
    private boolean flag=false;
    public synchronized void setName(String name,String age) {
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.age=age;
        flag=false;
        notify();
    }
    public synchronized void getName() {
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name+"====>"+this.age);
        flag=true;
        notify();
    }
}
