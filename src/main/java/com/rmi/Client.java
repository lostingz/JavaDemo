/**
 * Chsi
 * Created on 2016年5月9日
 */
package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Client {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        String url = "rmi://127.0.0.1/calculator";
        CalculateService calculateService=(CalculateService) Naming.lookup(url);
        int result=0;
        result = calculateService.add(100, 100);
        System.out.println(result);
    }
}
