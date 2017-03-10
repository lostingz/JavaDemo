/**
 * Chsi
 * Created on 2017年03月09日
 */
package com.proxytool;

import java.util.List;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    public static void main(String[] args) {
        ProxySpider spider=new ProxySpider();
        List<ProxyIPModel> proxyIpList = spider.getProxyIpList(ProxyIpTypeEnum.IN_HP);
        for (ProxyIPModel model : proxyIpList) {
            System.out.println(model.toString());
        }
    }
}
