/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.装饰者模式.简单例子;

public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator c) {
        super(c);
    }

    public String handleContent() {
        StringBuffer sb=new StringBuffer();
        sb.append("Cache-Control:no-cache\n");
        sb.append("Date:Mon,31 Dec201204:25:57GMT\n");
        sb.append(component.handleContent());
        return sb.toString();
    }

}
