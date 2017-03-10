/**
 * Chsi
 * Created on 2017年03月10日
 */
package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author zhenggm<a href="mailto:zhenggm@chsi.com.cn">zhenggm</a>
 * @version $Id$
 */
public class Test {
    static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }
    }

    static int partition(int[] arr, int left, int right) {
        int swapPosition = left;
        int pivot = arr[right];
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, swapPosition, i);
                swapPosition++;
            }
        }
        swap(arr, right, swapPosition);
        return swapPosition;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int swapPosition = partition(arr, left, right);
        quickSort(arr, left, swapPosition - 1);
        quickSort(arr, swapPosition + 1, right);
    }


    private static void swap(int[] arr, int i, int j) {
        if (i!=j) {
            System.out.println("交换" + arr[i] + "和" + arr[j]);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {46, 3, 5, 7, 2, 4, 5, 0, 22, 11, -1, -32, 12, 45, 33};
        //sort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

