/**
 * Chsi
 * Created on 2016年7月11日
 */
package com.program;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Val> map = new HashMap<Integer, Val>();
        for (int i = 0; i <= 2; i++) {
            map.put(i, new Val("1", "2", "3", "4"));
        }
        System.out.println(JSON.toJSONString(map));
    }
}

class Val {
    private String a;
    private String b;
    private String c;
    private String d;

    public Val(String a, String b, String c, String d) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
