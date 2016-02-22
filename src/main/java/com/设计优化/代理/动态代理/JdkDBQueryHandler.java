/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.代理.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.设计优化.代理.简单例子.DBQuery;
import com.设计优化.代理.简单例子.IDBQuery;

public class JdkDBQueryHandler implements InvocationHandler {

    IDBQuery real = null;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return method.invoke(real, args);
    }

}
