/**
 * Chsi
 * Created on 2015年12月8日
 */
package com.test;

import java.io.UnsupportedEncodingException;

public class TestLength {
    public static void main(String[] args) {
        String s = "发";
        try {
            System.out.println(s.getBytes("UTF-8").length / 8);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
