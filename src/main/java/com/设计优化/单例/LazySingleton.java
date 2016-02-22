/**
 * Chsi
 * Created on 2015年11月30日
 */
package com.设计优化.单例;

//虽然实现了延迟加载的功能，但是引入了同步关键字，因此在多线程环境中他的耗时超过第一种实现方式
public class LazySingleton {
    private LazySingleton() {
        System.out.println("创建单例");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                LazySingleton.getInstance();
            }
        }.start();
        new Thread() {
            public void run() {
                LazySingleton.getInstance();
            }
        }.start();
    }
}
