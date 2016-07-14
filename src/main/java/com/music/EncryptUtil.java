/**
 * Chsi
 * Created on 2016年6月22日
 */
package com.music;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.Md5Crypt;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class EncryptUtil {

    public static String getEncryptedId(String id) {
        byte[] magic = "3go8&$8*3*3h0k(2)2".getBytes();
        byte[] song_id = id.getBytes();
        int magicLen = magic.length;
        int count = song_id.length;
        for (int i = 0; i < count; i++) {
            song_id[i] = (byte) (song_id[i] ^ magic[i % magicLen]);
        }
        String result = Base64.encodeBase64String(Md5Crypt.md5Crypt(song_id).getBytes());
        result = result.replace("/", "_");
        result = result.replace("+", "-");
        return result;
    }

    public static void main(String[] args) {
        String id = "417859220";
        System.out.println(getEncryptedId(id));
    }
}
