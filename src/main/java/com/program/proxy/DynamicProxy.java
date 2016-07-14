/**
 * Chsi
 * Created on 2016年7月14日
 */
package com.program.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class DynamicProxy implements InvocationHandler {

    private IUserDao target;

    public DynamicProxy() {
        super();
    }

    public DynamicProxy(IUserDao target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("before method called");
    }

    private void after() {
        System.out.println("after method called");
    }

}
