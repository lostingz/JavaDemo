/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.代理.简单例子;

public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    public String request() {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

}
