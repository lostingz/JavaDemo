/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class SerializeUtil {
    public static <T> byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            oos = new ObjectOutputStream(bos);
            if (object instanceof List) {
                List<T> values = (List<T>) object;
                for (int i = 0; i <values.size() ; i++) {
                    oos.writeObject(values.get(i));
                }
            }
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    public static <T> Object deSerialize(byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        List<T> values = new ArrayList<T>();
        try {
            ObjectInputStream ois = new ObjectInputStream(bis);
            while (bis.available() > 0) {
                T data = (T) ois.readObject();
                if (data == null) {
                    break;
                }
                values.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return values;
    }
}
