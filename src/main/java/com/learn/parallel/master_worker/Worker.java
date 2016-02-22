package com.learn.parallel.master_worker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable{
    //任务队列，用于取得子任务
    protected Queue<Object> workQueue;
    //子任务结果集
    protected Map<String, Object> resultMap;
    
    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    /**
     * 子任务的处理逻辑，在子类中实现具体逻辑
     * @param input
     * @return
     */
    public Object handle(Object input){
        return input;
    }
    public void run() {
        while(true){
            Object input=workQueue.poll();
            if(input == null){
                break;
            }
            Object re=handle(input);
            resultMap.put(Integer.toString(input.hashCode()),re);
        }
    }

}
