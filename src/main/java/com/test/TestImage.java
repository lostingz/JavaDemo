package com.test;


public class TestImage {
    public static void main(String[] args) {
       //String url="http://www.chsi.com.cn";
       String url="http://588ku.com/tupian/";
       int pageCount=1;
       for (int i = 0; i < pageCount; i++) {
           ImageUtil.downloadImage(url,"","e:/test/image");
       }
       System.out.println("download finished!");
    }
    
}