/**
 * Chsi
 * Created on 2017年03月09日
 */
package com.proxytool;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class ProxyIPModel {
    private String ip;
    private String port;
    private String type;
    private String anonymous;
    private String address;
    private String isp;
    private String pingTime;
    private String transferTime;
    private String validateDateTime;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getPingTime() {
        return pingTime;
    }

    public void setPingTime(String pingTime) {
        this.pingTime = pingTime;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public String getValidateDateTime() {
        return validateDateTime;
    }

    public void setValidateDateTime(String validateDateTime) {
        this.validateDateTime = validateDateTime;
    }

    @Override
    public String toString() {
        return "{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", type='" + type + '\'' +
                ", anonymous='" + anonymous + '\'' +
                ", address='" + address + '\'' +
                ", isp='" + isp + '\'' +
                ", pingTime='" + pingTime + '\'' +
                ", transferTime='" + transferTime + '\'' +
                ", validateDateTime='" + validateDateTime + '\'' +
                '}';
    }
}
