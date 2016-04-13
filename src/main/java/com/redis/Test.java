/**
 * Chsi
 * Created on 2016年3月30日
 */
package com.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    public static void main(String[] args) {
        Jedis redis = new Jedis("127.0.0.1", 6379);
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 1000; i++) {
            list.add(new User("name" + i, i));
        }
        byte[] bytes = null;
        long start = System.currentTimeMillis();
        redis.set("userList".getBytes(), SerializeUtil.serialize(list));
        bytes = redis.get("userList".getBytes());
        System.out.println(System.currentTimeMillis() - start);
        List<String> result = (List<String>) SerializeUtil.deSerialize(bytes);
        System.out.println(System.currentTimeMillis() - start);
    }
}
