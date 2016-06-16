/**
 * Chsi
 * Created on 2016年6月15日
 */
package com.bing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class DownloadImg {
    public static void main(String[] args) {
        String url = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
        HttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            JSONObject json = JSON.parseObject(EntityUtils.toString(response.getEntity()));
            JSONArray obj = (JSONArray) JSONArray.parse(json.get("images").toString());
            String resourceUrl = obj.getJSONObject(0).get("url").toString();
            HttpGet request = new HttpGet(resourceUrl);
            HttpResponse resp = client.execute(request);
            if (resp.getStatusLine().getStatusCode() == 200) {
                InputStream in = resp.getEntity().getContent();
                byte[] b = new byte[1024];
                int len = 0;
                String path = "E:/testImage/bing/";
                File folder = new File(path);
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                File f = new File(path + sdf.format(new Date()) + ".jpg");
                if (!f.exists()) {
                    f.createNewFile();
                }
                OutputStream out = new FileOutputStream(f);
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                out.close();
                System.out.println("File is stored in: " + path);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
