/**
 * Chsi
 * Created on 2016年5月9日
 */
package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class CalculateServiceImpl extends UnicastRemoteObject implements CalculateService {

    private static final long serialVersionUID = 383097338414048259L;

    protected CalculateServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

}
