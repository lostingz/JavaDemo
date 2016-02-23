/**
 * Chsi
 * Created on 2016年2月23日
 */
package com.zhihu;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zhihu.avatar.User;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    public static void main(String[] args) {
        String url = "http://www.zhihu.com/question/" + "29507966";
        List<User> userList = new ArrayList<User>();
        try {
            Document dom = Jsoup.connect(url).userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                    .timeout(2000).get();
            Elements elems = dom.select(".Avatar").select("img");
            for (Element element : elems) {
                User user=new User();
                user.setLoginId(element.parent().attr("href"));
                user.setImgUrl(element.attr("src"));
                user.setName(element.parent().nextElementSibling().text());
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userList.size());
    }
}
