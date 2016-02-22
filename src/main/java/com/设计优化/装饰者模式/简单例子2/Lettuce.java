/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子2;

public class Lettuce extends Condiment {

    Hamburger hamburger;

    public Lettuce(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String getName() {
        return hamburger.getName() + "加生菜";
    }

    @Override
    public Double getPrice() {
        return hamburger.getPrice() + 1.5;
    }

}
