/**
 * Chsi
 * Created on 2017年03月09日
 */
package com.proxytool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.tool.HtmlTool;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class ProxySpider {
    public List<ProxyIPModel> getProxyIpList(ProxyIpTypeEnum type) {
        List<ProxyIPModel> result = new ArrayList<>();
        String url = type.getUrl();
        try {
            Document doc = HtmlTool.getDocumentKeepAlive(url);
            Elements tbody = doc.select("#list tbody tr");
            for (Element tr : tbody) {
                Elements tds = tr.children();
                ProxyIPModel model = new ProxyIPModel();
                model.setIp(tds.get(1).text());
                String imageUrl=Constants.SITE_URL+tds.get(2).child(0).attr("src");
//                File file=HtmlTool.downloadImgFromUrl(imageUrl,"temp","E:/ocr",new Date().getTime()+".png",5000);
//                model.setPort(ImageOCRUtil.getImageString(file.getAbsolutePath()));
                model.setType(tds.get(3).text());
                model.setAnonymous(tds.get(4).text());
                model.setAddress(tds.get(5).text());
                model.setIsp(tds.get(6).text());
                model.setPingTime(tds.get(7).attr("title"));
                model.setTransferTime(tds.get(8).attr("title"));
                model.setValidateDateTime(tds.get(9).text());
                result.add(model);
            }
        } catch (IOException e) {
            System.out.println("连接超时，网络异常"+e.getMessage());
        }finally {
            
        }
        return result;
    }
}
