/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.redis;

import java.io.Serializable;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4219375312810457974L;
    private String name;
    private int age;

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
