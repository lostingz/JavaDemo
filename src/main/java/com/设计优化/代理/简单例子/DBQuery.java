/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.代理.简单例子;

public class DBQuery implements IDBQuery {

    public DBQuery() {
        try {
            // 可能包含数据库等耗时操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String request() {
        return "响应请求";
    }
}
