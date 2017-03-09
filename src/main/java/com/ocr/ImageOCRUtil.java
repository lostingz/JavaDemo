/**
 * Chsi
 * Created on 2017年03月09日
 */
package com.ocr;

import java.io.FileInputStream;

import cn.easyproject.easyocr.EasyOCR;

/**
 * 图像文字识别工具
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class ImageOCRUtil {
    public static String getImageString(String path){
        EasyOCR e=new EasyOCR();
        //直接识别图片内容
        return "";
        //return e.discern(path);
    }

    public static String getImageString(FileInputStream fileInputStream){
        EasyOCR e=new EasyOCR();
        return e.discern(fileInputStream);
    }
}
