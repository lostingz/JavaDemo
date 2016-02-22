/**
 * Chsi
 * Created on 2015年11月26日
 */
package com.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DoubanMovieTest {
    public static void main(String[] args) {
        String url = "http://movie.douban.com/nowplaying/beijing/";
        try {
            Document dom = Jsoup.connect(url).userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                    .timeout(2000).get();
            Elements elems = dom.select("#nowplaying .mod-bd");
            Elements movieElems = elems.get(0).select(".list-item");
            int length = movieElems.size();
            for (int i = 0; i < length; i++) {
                Element movie = movieElems.get(i);
                String imgUrl = movie.select(".poster img").attr("src");
                String detailUrl = movie.select(".sbtn a").attr("href");
                String title = movie.attr("data-title");
                String actor = movie.attr("data-actors");
                String director = movie.attr("data-director");
                String country = movie.attr("data-region");
                String duration = movie.attr("data-duration");
                String score = movie.attr("data-score");
                System.out.println(title);
                System.out.println("主演:" + actor);
                System.out.println("导演:" + director);
                System.out.println(country);
                System.out.println(duration);
                System.out.println("评分:" + score);
                System.out.println("图片地址:" + imgUrl);
                System.out.println("详情地址:" + detailUrl);
                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
