/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.protobuf.test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.protobuf.model.UserProtos;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 33456);
            DataOutputStream out=new DataOutputStream(socket.getOutputStream());
            UserProtos.User.Builder userBuilder = UserProtos.User.newBuilder();
            userBuilder.setBirth("1999");
            userBuilder.setEmail("adsfa@163.com");
            userBuilder.setName("zhengdddd");
            userBuilder.setPassword("123456");
            userBuilder.setPhone(1332222111179l);
            UserProtos.User user = userBuilder.build();
            byte[] userByteArr= user.toByteArray();
            out.writeInt(userByteArr.length);
            out.write(userByteArr);
            out.close();
            socket.close();
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
