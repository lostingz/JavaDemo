/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.代理.动态代理;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibDBQueryInterceptor implements MethodInterceptor {


    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(method.getName() + "执行前");
        Object result = proxy.invokeSuper(object, args);
        System.out.println(method.getName() + "执行后");
        return result;
    }

}
