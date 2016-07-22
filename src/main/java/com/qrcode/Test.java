/**
 * Chsi
 * Created on 2016年7月18日
 */
package com.qrcode;

import java.io.File;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifDirectory;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    public static void main(String[] args) throws Exception {
        File jpegFile = new File("F:/test.jpg");
        Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
        Directory exif = metadata.getDirectory(ExifDirectory.class);
        String model = exif.getString(ExifDirectory.TAG_ORIENTATION);
        System.out.println(model);
    }
}
