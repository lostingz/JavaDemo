/**
 * Chsi
 * Created on 2015年11月18日
 */
package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("test.txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
