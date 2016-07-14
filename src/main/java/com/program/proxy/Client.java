/**
 * Chsi
 * Created on 2016年7月14日
 */
package com.program.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Client {
    public static void main(String[] args) {
        // dynamic
        IUserDao service = new UserImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(service);
        IUserDao userDaoProxy = (IUserDao) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass()
                .getInterfaces(), dynamicProxy);
        userDaoProxy.create();

    }
}