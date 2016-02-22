/**
 * Chsi
 * Created on 2015年11月25日
 */
package com.javanio;

import java.nio.ByteBuffer;

public class Buffer基本原理 {
    public static void main(String[] args) {
        // 15个字节大小的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(15);
        printInfo(buffer);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        printInfo(buffer);
        buffer.flip();
        printInfo(buffer);
        for (int i = 0; i < 5; i++) {
            System.out.print(buffer.get() + " ");
        }
        System.out.println();
        printInfo(buffer);
        buffer.flip();
        printInfo(buffer);
        for (int i = 0; i < 5; i++) {
            System.out.print(buffer.get() + " ");
        }
    }

    private static void printInfo(ByteBuffer buffer) {
        System.out.println("limit=" + buffer.limit() + " capacity=" + buffer.capacity() + " position=" + buffer.position());
    }
}
