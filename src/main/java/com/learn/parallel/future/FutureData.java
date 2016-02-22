package com.learn.parallel.future;

public class FutureData implements Data{
    protected RealData realData=null;
    protected boolean isReady=false;
    public String getResult() {
        return getRealData();
    }
    public synchronized void setRealData(RealData realData) {
        if(isReady){
            return;
        }
        this.realData = realData;
        System.out.println("realData设置完成");
        isReady=true;
        notifyAll();
    }
    public synchronized String getRealData() {
        while(!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("获取realData");
        return realData.result;
    }

}
