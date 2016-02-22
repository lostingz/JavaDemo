/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.观察者模式;

public class Main {
    public static void main(String[] args) {
        Watched girl = new ConcreteWatched();
        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();
        Watcher watcher4 = new ConcreteWatcher();
        girl.addWatcher(watcher1);
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);
        girl.addWatcher(watcher4);
        girl.notifyWatcher("ddd");
    }
}
