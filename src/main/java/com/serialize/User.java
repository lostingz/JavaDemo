/**
 * Chsi
 * Created on 2016年4月8日
 */
package com.serialize;

import java.io.Serializable;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1188685311115516970L;
    private String name;
    private String language;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
