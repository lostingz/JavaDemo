/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.观察者模式;

public class ConcreteWatcher implements Watcher {
    private String watcherName;

    public ConcreteWatcher() {
        super();
    }

    public ConcreteWatcher(String watcherName) {
        super();
        this.watcherName = watcherName;
    }

    public void update(String str) {
        System.out.println(watcherName + str);
    }

}
