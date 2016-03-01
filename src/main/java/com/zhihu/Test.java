package com.zhihu;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.zhihu.config.UserInfoConfig;
import com.zhihu.tool.zhihuTool;

public class Test {

    public static void main(String[] args) {
        try {
            boolean loginSuccess = zhihuTool.login(UserInfoConfig.EMAIL, UserInfoConfig.PASSWD);
            if (loginSuccess) {
                String url = "http://www.zhihu.com/people/excited-vczh";
                Document doc = Jsoup.connect(url).get();
                System.out.println(doc.html());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}