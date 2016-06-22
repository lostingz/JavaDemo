/**
 * Chsi
 * Created on 2016年5月9日
 */
package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public interface CalculateService extends Remote {
    int add(int a, int b) throws RemoteException;;
}
