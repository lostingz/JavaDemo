/**
 * Chsi
 * Created on 2017年03月07日
 */
package com.java8;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class InnerStaticClass {

    public InnerStaticClass() {
        System.out.println("class constructor");
    }
    
    public Byte getByte(){
        return Cache.cache[3];
    }

    private static class Cache{
        static final Byte[] cache=new Byte[-(Byte.MIN_VALUE)+Byte.MAX_VALUE];
        static {
            System.out.println("innerStaticClass static block constructor");
            for (int i = 0; i < cache.length; i++) {
                cache[i]=new Byte((byte)(i-128));
            }
        }
    }
}
