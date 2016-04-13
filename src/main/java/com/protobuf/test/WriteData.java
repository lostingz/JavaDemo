/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.protobuf.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.protobuf.model.UserProtos;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class WriteData {
    public static void main(String[] args) {
        UserProtos.User.Builder userBuilder = UserProtos.User.newBuilder();
        userBuilder.setBirth("1999");
        userBuilder.setEmail("adsfa@163.com");
        userBuilder.setName("zhengd");
        userBuilder.setPassword("123456");
        userBuilder.setPhone(1332222111179l);
        UserProtos.User user = userBuilder.build();
        File file = new File("E:/test/test_protobuf");
        try {
            FileOutputStream out = new FileOutputStream(file);
            user.writeTo(out);
            out.close();
            System.out.println("write success");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
