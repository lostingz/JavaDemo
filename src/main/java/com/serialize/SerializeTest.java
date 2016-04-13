/**
 * Chsi
 * Created on 2016年4月8日
 */
package com.serialize;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class SerializeTest {

    public static void SerializeObj(List<User> userList, File file) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(userList);
        System.out.println("serialize success");
        oos.close();
    }
    
    @SuppressWarnings("unchecked")
    public static void DeSerializeObj(File file, List<User> userList) throws FileNotFoundException, IOException,
            ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        userList = (List<User>) ois.readObject();
        for (User user : userList) {
            System.out.println("name:" + user.getName() + " language:" + user.getLanguage() + " age" + user.getAge());
        }
        ois.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("E:/test/serializeTest.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<User> list = new ArrayList<User>(1000);
        for (int i = 0; i < 1000; i++) {
            User u = new User();
            u.setName("zheng" + i);
            u.setLanguage("English");
            u.setAge(i);
            list.add(u);
        }
        File jsonFile = new File("E:/test/serializeTestJson.txt");
        String jsonArr = JSONArray.toJSONString(list);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(jsonFile));
        byte[] b = jsonArr.getBytes();
        int len = b.length;
        try {
            bos.write(b, 0, len);
            bos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            SerializeObj(list, file);
            DeSerializeObj(file, list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
