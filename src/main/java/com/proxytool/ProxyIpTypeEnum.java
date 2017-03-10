/**
 * Chsi
 * Created on 2017年03月09日
 */
package com.proxytool;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public enum  ProxyIpTypeEnum {
    IN_TP("国内普通","http://proxy.mimvp.com/free.php?proxy=in_tp"),
    IN_HP("国内高匿","http://proxy.mimvp.com/free.php?proxy=in_hp"),
    OUT_TP("国外普通","http://proxy.mimvp.com/free.php?proxy=out_tp"),
    OUT_HP("国外高匿","http://proxy.mimvp.com/free.php?proxy=out_hp"),
    IN_SOCKS("Socks国内","http://proxy.mimvp.com/free.php?proxy=in_socks"),
    OUT_SOCKS("Socks国外","http://proxy.mimvp.com/free.php?proxy=out_socks");
    private String typeName;
    private String url;

    ProxyIpTypeEnum(String typeName, String url) {
        this.typeName = typeName;
        this.url = url;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getUrl() {
        return url;
    }
}
