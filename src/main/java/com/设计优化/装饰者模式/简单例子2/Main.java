/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子2;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new ChickenBurger();
        System.out.println(hamburger.getName() + "  价钱：" + hamburger.getPrice());
        Lettuce lettuce = new Lettuce(hamburger);
        System.out.println(lettuce.getName() + "  价钱：" + lettuce.getPrice());
        Chilli c = new Chilli(hamburger);
        System.out.println(c.getName() + "  价钱：" + c.getPrice());
    }
}
