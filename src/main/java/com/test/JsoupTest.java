/**
 * Chsi
 * Created on 2015年11月25日
 */
package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
    public static void main(String[] args) {
        String url = "http://www.ygdy8.net/html/gndy/dyzz/index.html";
        List<String> list = getPage(url);
    }

    private static List<String> getPage(String url) {
        Connection conn = Jsoup.connect(url);
        List<String> list = new ArrayList<String>();
        try {
            Document doc = conn.get();
            Elements elements = doc.select(".co_content2").get(1).select("a");
            for (Element element : elements) {
                if (StringUtils.isNotBlank(element.attr("href"))) {
                    String pageUrl = "http://www.ygdy8.net" + element.attr("href");
                    String title = element.text();
                    System.out.println(title);
                    getFtpAddr(pageUrl, title);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void getFtpAddr(String pageUrl, String title) {
        Connection conn = Jsoup.connect(pageUrl);
        List<String> list = new ArrayList<String>();
        try {
            Document doc = conn.get();
            Elements elements = doc.select("#Zoom tbody a");
            for (Element element : elements) {
                if (StringUtils.isNotBlank(element.attr("href"))) {
                    System.out.println(element.attr("href"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
