/**
 * Chsi
 * Created on 2015年11月26日
 */
package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DoubanBookDemo {
    public static void main(String[] args) throws IOException {
        Document dom = Jsoup.connect("http://book.douban.com/latest?icn=index-latestbook-all").get();
        // 根据jquery
        Elements es = dom.select("#content li").not(".clear");
        for (int i = 0; i < es.size(); i++) {
            Element e = es.get(i);// li
            String title = e.select("h2").get(0).text();
            System.err.println("title:" + title);
            Elements esp = e.select("p");
            Element p1 = esp.get(0);
            String auth = p1.text();
            System.err.println("auth:" + auth);
            String text = esp.get(1).text();
            System.err.println(text);

            final String url = e.select("img").get(0).attr("src");
            System.err.println(url);

            new Thread() {
                public void run() {
                    try {
                        String fileName = url.substring(url.lastIndexOf("/") + 1);
                        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
                        con.setConnectTimeout(3000);
                        con.setRequestMethod("GET");
                        con.setDoInput(true);
                        con.connect();
                        int code = con.getResponseCode();
                        if (code == 200) {
                            InputStream in = con.getInputStream();
                            byte[] b = new byte[1024];
                            int len = 0;
                            OutputStream out = new FileOutputStream("E:/test/" + fileName);
                            while ((len = in.read(b)) != -1) {
                                out.write(b, 0, len);
                            }
                            out.close();
                        }
                        con.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
            }.start();

            System.err.println("-------------------");
        }
        System.in.read();
    }
}