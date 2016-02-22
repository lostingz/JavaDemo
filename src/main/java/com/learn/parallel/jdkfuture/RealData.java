package com.learn.parallel.jdkfuture;

import java.util.concurrent.Callable;

public class RealData implements Callable<String>{
    private String para;
    public RealData(String para){
        this.para=para;
    }
    public String call() throws Exception {
        //这里是真实的业务逻辑，执行可能很慢
        StringBuffer sb=new StringBuffer();
        for(int i = 0;i < 10; i++){
            sb.append(para);
            Thread.sleep(1000);
        }
        return sb.toString();
    }

}
