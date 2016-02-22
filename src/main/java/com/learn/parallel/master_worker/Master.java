package com.learn.parallel.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
    //任务队列
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
    //worker进程队列
    protected Map<String,Thread> threadMap = new HashMap<String, Thread>();
    //子任务处理结果集
    protected Map<String,Object> resultMap = new HashMap<String,Object>();
    /**
     * 是否所有的子任务都结束了
     */
    public boolean isComplete(){
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if(entry.getValue().getState()!=Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }
    /**
     * Master的构造，需要一个worker的进程逻辑，和需要worker的数量
     * @param worker
     * @param countWorker
     */
    public Master(Worker worker,int countWorker){
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }
    /**
     * 提交一个任务
     * @param obj
     */
    public void submit(Object obj){
       workQueue.add(obj); 
    }
    /**
     * 返回子任务的结果集
     * @return
     */
    public Map<String, Object> getResultMap(){
        return resultMap;
    }
    public void execute(){
        for(Map.Entry<String, Thread> entry:threadMap.entrySet()){
            entry.getValue().start();
        }
    }
    
}
