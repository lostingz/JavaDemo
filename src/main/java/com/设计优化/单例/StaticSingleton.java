/**
 * Chsi
 * Created on 2015年11月30日
 */
package com.设计优化.单例;

//使用内部类来维护单例的实例，单StaticSingleton被加载的时候，其内部类并不会初始化，故而可以
//保证当StaticSingleton类被载入JVM的时候，不会初始化instance，而当getInstance方法被调用的时候，才会加载SingletonHolder内部类，
//从而初始化instance，同时由于实例的建立是在类加载的时候完成，故天生对线程友好，getInstance方法也不需要同步关键字。
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("创建单例");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        StaticSingleton.getInstance();
    }
}
