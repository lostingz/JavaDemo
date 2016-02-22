/**
 * Chsi
 * Created on 2015年11月25日
 */
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    public static void main(String[] args) {
        String site = "http://www.verycd.com";
        try {
            URL url = new URL(site);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
