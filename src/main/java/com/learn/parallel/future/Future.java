package com.learn.parallel.future;

public class Future {
    public static void main(String[] args) {
        Client client=new Client();
        Data data=client.request("name");
        System.out.println("请求完毕");
        try {
            //用一个sleep代替对其他业务逻辑的处理，在处理其他逻辑的时候，RealData被创建，从而充分利用了等待时间
            System.out.println("处理其他业务开始");
            Thread.sleep(2000);
            System.out.println("处理其他业务结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用真实的数据
        System.out.println(data.getResult());
    }
}
