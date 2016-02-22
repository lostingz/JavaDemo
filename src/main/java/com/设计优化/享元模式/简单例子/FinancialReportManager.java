/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.享元模式.简单例子;

public class FinancialReportManager implements IReportManager {

    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }
    public String createReport() {
        return "this is a financial report";
    }
}
