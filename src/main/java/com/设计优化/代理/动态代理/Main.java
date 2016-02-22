/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.代理.动态代理;

import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

import com.设计优化.代理.简单例子.DBQuery;
import com.设计优化.代理.简单例子.IDBQuery;

public class Main {
    public static void main(String[] args) {
        IDBQuery query = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IDBQuery.class},
                new JdkDBQueryHandler());
        String s = query.request();
        System.out.println(s);
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDBQueryInterceptor());
        enhancer.setSuperclass(DBQuery.class);
        IDBQuery queryCglib = (IDBQuery) enhancer.create();
        System.out.println(queryCglib.request());
    }
}
