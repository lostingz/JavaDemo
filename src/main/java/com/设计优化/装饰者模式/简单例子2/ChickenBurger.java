/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子2;

public class ChickenBurger extends Hamburger {

    public ChickenBurger() {
        name = "鸡腿堡";
    }

    @Override
    public Double getPrice() {
        return 10.0;
    }

}
