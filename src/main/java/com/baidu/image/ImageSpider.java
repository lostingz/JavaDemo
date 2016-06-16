/**
 * Chsi
 * Created on 2016年3月8日
 */
package com.baidu.image;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.util.URLUtil;
import com.zhihu.tool.zhihuTool;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class ImageSpider {
    public static void main(String[] args) {
        String keyword = "剪纸";
        String pageNum = "10";// 获取多少页
        String returnNum = "60";// 每页图的个数
        int count = 0;
        for (int j = 1; j <= Integer.valueOf(pageNum); j++) {
            String url = URLUtil.getQueryUrl(keyword, String.valueOf(j), returnNum);
            HttpClient httpClient = HttpClients.createDefault();
            if (URLUtil.isHttps(url)) {
                httpClient = zhihuTool.getHttpsClient();
            }
            HttpGet request = new HttpGet(url);
            HttpResponse response;
            try {
                response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    JSONObject jsonData = JSONObject.parseObject(EntityUtils.toString(entity));
                    JSONArray data = (JSONArray) jsonData.get("data");
                    for (int i = 0; i < data.size(); i++) {
                        JSONObject imgJson = (JSONObject) data.get(i);
                        String encodeStr = imgJson.getString("objURL");
                        if (StringUtils.isNotBlank(encodeStr)) {
                            String resoureUrl = URLUtil.decodeToUrl(encodeStr);
                            System.out.println(resoureUrl);
                            count++;
                            // URLUtil.downloadImgByUrl(resoureUrl);//下载到硬盘
                        }
                    }
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(count);
    }
}
