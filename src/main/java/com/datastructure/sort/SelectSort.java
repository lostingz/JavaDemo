/**
 * Chsi
 * Created on 2016年4月13日
 */
package com.datastructure.sort;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class SelectSort {
    public static void sort(int[] arr) {
        if (arr.length < 0) {
            return;
        }
        int max=0;
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            max = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 3, 2, 7, 0, 2, 9};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
