/**
 * Chsi
 * Created on 2017年03月07日
 */
package com.java8;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class InnerStaticClassTest {
    public static void main(String[] args) {
        InnerStaticClass innerStaticClass=new InnerStaticClass();
        innerStaticClass.getByte();
        innerStaticClass.getByte();
        InnerStaticClass innerStaticClass2=new InnerStaticClass();
        innerStaticClass2.getByte();
    }
}
