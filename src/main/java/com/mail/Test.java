/**
 * Chsi
 * Created on 2016年4月14日
 */
package com.mail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    public static void main(String[] args) {
        
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            File folderPath = new File("e:/test/image/");
            File[] files = getFiles(folderPath.getAbsolutePath());
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    files[i].renameTo(new File(files[i].getAbsolutePath().replace(".png", ".txt")));
                }
            }
            // int len = 0;
            // byte[] b = new byte[1024];
            // while ((len = bis.read(b)) > 0) {
            // bos.write(b, 0, len);
            // }
            // System.out.println(bos.size());
            // for (int i = 0; i < 10; i++) {
            // bos.writeTo(new FileOutputStream(new
            // File("e:/test/image/code_bak" + i + ".txt")));
            // }
            // /bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public static File[] getFiles(String folderPath) {
        File[] files=null;
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            files = folder.listFiles();
        } else {
            System.out.println(folderPath + "is not a folder");
        }
        return files;
    }
}
