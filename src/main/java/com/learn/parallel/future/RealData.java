package com.learn.parallel.future;

public class RealData implements Data {
    protected final String result;
    public RealData(String para){
        //RealData的构造很慢，这里用sleep模拟
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result=sb.toString();
    }
    public String getResult() {
        return result;
    }

}
