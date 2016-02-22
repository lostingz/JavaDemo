/**
 * Chsi
 * Created on 2015年11月25日
 */
package com.javanio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String mode = "rw";
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(fileName, mode);
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Fount!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
