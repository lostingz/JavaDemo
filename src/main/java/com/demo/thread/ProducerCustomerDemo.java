package com.demo.thread;

public class ProducerCustomerDemo {
    public static void main(String[] args) {
        Info info=new Info();
        Producer producer=new Producer(info);
        Customer customer=new Customer(info);
        Thread ta=new Thread(producer);
        Thread tb=new Thread(customer);
        ta.start();
        tb.start();
    }
}
