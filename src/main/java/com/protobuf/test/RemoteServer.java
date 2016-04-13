/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.protobuf.test;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.protobuf.model.UserProtos;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class RemoteServer {
    public static void main(String[] args) {
        int port=33456;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            Socket socket=server.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            int length = in.readInt();
            if (length > 0) {
                byte[] userByteArr = new byte[length];
                in.readFully(userByteArr);
                UserProtos.User user = UserProtos.User.parseFrom(userByteArr);
                System.out.println(user.getName());
            }
            in.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
