/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        if (arr.length <= 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 3, 2, 7, 0, 2, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
