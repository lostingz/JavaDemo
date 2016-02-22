/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子2;

//现在需要一个汉堡，主体是鸡腿堡，可以选择添加生菜、酱、辣椒等等许多其他的配料，这种情况下就可以使用装饰者模式。
public abstract class Hamburger {

    protected String name;

    public String getName() {
        return name;
    }

    public abstract Double getPrice();
}
