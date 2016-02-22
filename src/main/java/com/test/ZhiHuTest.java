/**
 * Chsi
 * Created on 2015年12月23日
 */
package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ZhiHuTest {
    public static void main(String[] args) {
        String url = "http://www.zhihu.com/question/21532120";
        try {
            Document dom = Jsoup.connect(url).userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                    .timeout(2000).get();
            Elements elems = dom.select("#zh-question-title");
            String title = elems.get(0).text();
            System.out.println(title);
            Elements answers = dom.select(".zm-editable-content");
            int length = answers.size();
            for (int i = 1; i < length; i++) {
                Element link = answers.get(i);
                System.out.println(link.html());
                System.out.println("===========================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
