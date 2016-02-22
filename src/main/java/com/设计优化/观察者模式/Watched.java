/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.观察者模式;

public interface Watched {
    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatcher(String str);
}
