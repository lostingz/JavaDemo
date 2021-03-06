/**
 * Chsi
 * Created on 2016年3月1日
 */
package com.zhihu.tool;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class zhihuTool {
    public static String getXsrf(HttpClient httpclient) throws ClientProtocolException, IOException {
        HttpGet httpget = new HttpGet("http://www.zhihu.com/");
        HttpResponse resp = httpclient.execute(httpget);
        HttpEntity entity = resp.getEntity();
        String html = EntityUtils.toString(entity);
        Document document = Jsoup.parse(html);
        Element element = document.select("input[name=_xsrf]").first();
        return element.attr("value");
    }
    
    private static List<NameValuePair> generateLoginData(String email, String password, String xsrf, boolean remember) {
        List<NameValuePair> data = new ArrayList<NameValuePair>();
        data.add(new BasicNameValuePair("email", email));
        data.add(new BasicNameValuePair("password", password));
        data.add(new BasicNameValuePair("_xsrf", xsrf));
        data.add(new BasicNameValuePair("remember_me", "true"));
        return data;
    }

    public static boolean login(String email, String password) throws ClientProtocolException, IOException {
        boolean isLoginSuccess = false;
        HttpClient httpclient = HttpClients.createDefault();
        String url = "http://www.zhihu.com/login/email";
        List<NameValuePair> postData = generateLoginData(email, password, getXsrf(httpclient), true);
        HttpPost httppost = new HttpPost(url);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData, "UTF-8");
        httppost.setEntity(entity);
        HttpResponse res = httpclient.execute(httppost);
        HttpEntity resEntity = res.getEntity();
        String responseJsonStr = EntityUtils.toString(resEntity);
        JSONObject json = JSON.parseObject(responseJsonStr);
        System.out.println(json.toJSONString());
        return json.getString("r").equals("0");
    }

    public static HttpClient getHttpsClient() {
        HttpClient httpClient = null;
        SSLContext context;
        try {
            context = SSLContext.getInstance("SSL");
            context.init(null, new TrustManager[] {new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
                        throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
                        throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

            }}, new SecureRandom());

            HostnameVerifier verifier = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(context, verifier);
            httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpClient;
    }
}
