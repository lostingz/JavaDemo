/**
 * lostingz
 * Created on 2016年8月15日
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.win10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class ScreenImage {
    private static ArrayList<File> getListFiles(Object obj) {
        File directory = null;
        if (obj instanceof File) {
            directory = (File) obj;
        } else {
            directory = new File(obj.toString());
        }
        ArrayList<File> files = new ArrayList<File>();
        if (directory.isFile()) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (int i = 0; i < fileArr.length; i++) {
                File fileOne = fileArr[i];
                files.addAll(getListFiles(fileOne));
            }
        }
        return files;
    }

    public static void saveTo(String saveToPath) {
        String localAppData = System.getenv("localappdata");
        String imagePath = localAppData
                + "/Packages/Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy/LocalState/Assets";
        List<File> files = getListFiles(imagePath);
        File folder = new File(saveToPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        FileChannel fc = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            for (File f : files) {
                FileInputStream fis = new FileInputStream(f);
                FileOutputStream fos = new FileOutputStream(saveToPath + "/" + f.getName() + ".jpg");
                in = fis.getChannel();
                out = fos.getChannel();
                in.transferTo(0, in.size(), out);
            }
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String saveToPath = "E:/testImage/win10/";
        saveTo(saveToPath);
    }
}
