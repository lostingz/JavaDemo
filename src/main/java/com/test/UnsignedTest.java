/**
 * Chsi
 * Created on 2015年12月23日
 */
package com.test;

public class UnsignedTest {
    public static void main(String[] args) {
        byte n = (byte) 234;
        int i = n;
        i = i & 0xff;
        System.out.println(i);
    }
}
