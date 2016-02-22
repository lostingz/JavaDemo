/**
 * Chsi
 * Created on 2015年12月1日
 */
package com.设计优化.享元模式.简单例子;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {
    Map<String, IReportManager> financialManager = new HashMap<String, IReportManager>();
    Map<String, IReportManager> employeeManager = new HashMap<String, IReportManager>();

    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager r = financialManager.get(tenantId);
        if (r == null) {
            r = new FinancialReportManager(tenantId);
            financialManager.put(tenantId, r);
        }
        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId) {
        IReportManager r = employeeManager.get(tenantId);
        if (r == null) {
            r = new EmployeeReportManager(tenantId);
            employeeManager.put(tenantId, r);
        }
        return r;
    }
}
