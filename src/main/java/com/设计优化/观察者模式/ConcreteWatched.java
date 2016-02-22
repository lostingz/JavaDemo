/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ConcreteWatched implements Watched {
    // 存放观察者
    private List<Watcher> observers = new ArrayList<Watcher>();

    public void addWatcher(Watcher watcher) {
        observers.add(watcher);
    }

    public void removeWatcher(Watcher watcher) {
        observers.remove(watcher);
    }

    public void notifyWatcher(String str) {
        for (Watcher observer : observers) {
            observer.update(str);
        }
    }
}
