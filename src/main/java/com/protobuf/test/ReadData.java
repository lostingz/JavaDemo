/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.protobuf.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.protobuf.model.UserProtos;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class ReadData {
    public static void main(String[] args) {
        File file = new File("E:/test/test_protobuf");
        FileInputStream fis;
        try {
            UserProtos.User userIn = null;
            fis = new FileInputStream(file);
            userIn = UserProtos.User.parseFrom(fis);
            System.out.println(userIn.getName() + userIn.getPassword());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
