/**
 * Chsi
 * Created on 2016年5月9日
 */
package com.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class CalculateServer {
    public static void main(String[] args) {
        try {
            // 启动RMI注册服务，指定端口为1099　（1099为默认端口）
            // 也可以通过命令 ＄java_home/bin/rmiregistry 1099启动
            // 这里用这种方式避免了再打开一个DOS窗口
            // 而且用命令rmiregistry启动注册服务还必须事先用RMIC生成一个占位程序(stub类)为它所用
            LocateRegistry.createRegistry(1099);
            // 创建远程对象的一个或多个实例，下面是CalculateService对象
            // 可以用不同名字注册不同的实例
            CalculateService service = new CalculateServiceImpl();
            // 把service注册到RMI注册服务器上，命名为calculator
            Naming.rebind("calculator", service);
            // 如果要把service实例注册到另一台启动了RMI注册服务的机器上
            // Naming.rebind("//192.168.1.105:1099/calculator",service);
            System.out.println("Service Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
