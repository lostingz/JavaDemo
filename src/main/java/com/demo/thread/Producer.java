package com.demo.thread;
public class Producer implements Runnable{
    private Info info=null;
    public Producer(Info info){
        this.info=info;
    }
    public void run() {
        boolean flag=false;
        for (int i = 0; i < 25; i++) {
            if(flag){
                this.info.setName("A","1");
                flag=false;
            }else{
                this.info.setName("B", "2");
                flag=true;
            }
        }
    }
}
