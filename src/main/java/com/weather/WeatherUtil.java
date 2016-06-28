/**
 * Chsi
 * Created on 2016年6月28日
 */
package com.weather;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class WeatherUtil {
    public static String getCurrentWeather() {
        String result = null;
        String url = "http://www.weather.com.cn/weather/101010100.shtml";
        try {
           HttpClient client=HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                Document doc = Jsoup.parse(EntityUtils.toString(entity, "UTF-8"));
                String weather = doc.select("#hidden_title").attr("value");
                String updateTime = doc.select("#update_time").attr("value");
                String year=doc.select("#fc_7d_update_time").attr("value").substring(0,4);
                return year + "年" + weather + "[更新时间" + updateTime + "]";
            }
        } catch (Exception e) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            getCurrentWeather();
        }
        return result;
    }
}
