/**
 * Chsi
 * Created on 2016年7月14日
 */
package com.program.proxy;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class UserImpl implements IUserDao {

    @Override
    public void create() {
        System.out.println("create user success");
    }

    @Override
    public void create21() {
        System.out.println("create21 user success");
    }

}
