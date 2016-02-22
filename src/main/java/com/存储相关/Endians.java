/**
 * Chsi
 * Created on 2015年11月25日
 */
package com.存储相关;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * ByteBuffer中字节存储次序 java中的大小端 存储量大于1字节，非char类型，如int，float等，
 * 要考虑字节的顺序问题了。java由于虚拟机的关系,屏蔽了大小端问题, 需要知道的话可用 ByteOrder.nativeOrder() 查询。
 * 在操作ByteBuffer中，也可以使用 ByteBuffer.order() 进行设置：
 */
public class Endians {
    public static void main(String[] args) {
        // 创建12个字节的字节缓冲区
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        // 存入字符串
        bb.asCharBuffer().put("abdcef");
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }
}
