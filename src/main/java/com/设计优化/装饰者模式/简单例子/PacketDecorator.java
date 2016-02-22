/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子;

public abstract class PacketDecorator implements IPacketCreator {
    protected IPacketCreator component;

    public PacketDecorator(IPacketCreator c) {
        component = c;
    }
}
