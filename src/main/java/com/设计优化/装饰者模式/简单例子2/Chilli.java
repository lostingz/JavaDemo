/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子2;

public class Chilli extends Condiment {

    Hamburger humburger;

    public Chilli(Hamburger humburger) {
        this.humburger = humburger;

    }

    @Override
    public String getName() {
        return humburger.getName() + " 加辣椒";
    }

    @Override
    public Double getPrice() {
        return humburger.getPrice(); // 辣椒免费
    }

}
