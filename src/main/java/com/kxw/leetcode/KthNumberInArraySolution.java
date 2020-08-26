package com.kxw.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kangxiongwei
 * @date 2020-06-23 10:46
 */
public class KthNumberInArraySolution {

    public static void main(String[] args) {
        int k = 7;
        int[] array = new int[]{1, 3, 4, 5, 6, 2, 3};
        System.out.println(quickSortSearchKth(array, k));
    }

    /**
     * 利用快速排序找出第k小的数字
     *
     * @return
     */
    public static int quickSortSearchKth(int[] array, int k) {
        return quickSort(array, 0, array.length - 1, k);
    }

    public static int quickSort(int[] array, int left, int right, int k) {
        int i = left, j = right;
        int value = array[i];
        while (i < j) {
            //从右向左扫描
            while (i < j && array[j] > value) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            //从左向右扫描
            while (i < j && array[i] <= value) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = value;
        if (i == k - 1) {
            return array[i];
        } else if (i < k - 1) {
            return quickSort(array, i + 1, right, k);
        } else {
            return quickSort(array, left, i - 1, k);
        }
    }


}
