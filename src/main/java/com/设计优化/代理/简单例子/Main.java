/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.代理.简单例子;

public class Main {
    public static void main(String[] args) {
        IDBQuery query = new DBQueryProxy();
        String s = query.request();
        System.out.println(s);
    }
}
