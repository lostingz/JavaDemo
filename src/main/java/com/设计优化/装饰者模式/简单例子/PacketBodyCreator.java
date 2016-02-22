/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子;

/**
 * 返回数据包的核心数据
 * 
 * @version $Id$
 */
public class PacketBodyCreator implements IPacketCreator {

    public String handleContent() {

        return "核心数据，但是没有格式";
    }
}
