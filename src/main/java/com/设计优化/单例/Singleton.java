/**
 * Chsi
 * Created on 2015年11月30日
 */
package com.设计优化.单例;
//这一种实现，即使没有使用单例类，但是他还是被创建出来
public class Singleton {
    private Singleton() {
        System.out.println("创建单例");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
