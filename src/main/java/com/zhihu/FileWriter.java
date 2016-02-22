/**
 * Chsi
 * Created on 2016年1月8日
 */
package com.zhihu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class FileWriter {
    public static void write(String str) {
        File f = new File("e:\\zhihuSpider.html");
        try {
            newFile(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true), "utf-8"));
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void newFile(File f) {
        if (!f.exists()) {
            try {
                f.createNewFile();
                BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(f, true));
                String code = "<!DOCTYPE html><html><head><title>"
                        + "</title><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body>";
                bw.write(code);
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
