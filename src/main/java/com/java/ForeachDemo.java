/**
 * Chsi
 * Created on 2017年03月08日
 */
package com.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class ForeachDemo {
    private void initList(List<String> list) {
        int i=0;
        while (i<10){
            list.add("value"+i);
            i++;
        }
    }    
    public static void main(String[] args) {
        ForeachDemo demo=new ForeachDemo();
        List<String> list=new ArrayList<>();
        demo.initList(list);
        System.out.println("----------method1-----------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------method2-----------");
        for (String s : list) {
            System.out.println(s);
            //ConcurrentModificationException,其实JAVA中的增强for循环底层是通过迭代器模式来实现的。
            //list.remove(s);
        }
        System.out.println("----------method3-----------");
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            String s= (String) iterator.next();
            if(s.equals("value1")){
                //安全删除
                iterator.remove();
            }else{
                System.out.println(s);    
            }
        }
    }
}
