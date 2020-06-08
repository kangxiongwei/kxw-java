package com.kxw.leetcode;

import java.util.Collection;
import java.util.Collections;

/**
 * 有两个大小分别为m和n的有序数组A和B。请找出这两个数组的中位数。你需要给出时间复杂度在O(log (m+n))以内的算法。
 *
 * @author kangxiongwei
 * @date 2020-06-04 18:05
 */
public class MedianSortedArraysSolution {

    public static void main(String[] args) {
        MedianSortedArraysSolution solution = new MedianSortedArraysSolution();
        double arrays = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{1});
        System.out.println(arrays);
    }

    /**
     * @param A int整型一维数组
     * @param B int整型一维数组
     * @return double浮点型
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[] total = merge(A, B, new int[len1 + len2], 0, 0, 0);
        boolean flag = (len1 + len2) % 2 == 0;     //是否是偶数，偶数的中位数是第N/2个元素和第N/2+1
        if (flag) {
            int value1 = (len1 + len2) / 2;
            int value2 = (len1 + len2) / 2 - 1;
            return (total[value1] + total[value2]) / 2.0;
        } else {
            return total[(len1 + len2) / 2];
        }
    }

    /**
     * 归并排序合并数组
     *
     * @param A
     * @param B
     * @param total
     * @param i
     * @param j
     * @param t
     * @return
     */
    private int[] merge(int[] A, int[] B, int[] total, int i, int j, int t) {
        if (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                total[t] = A[i];
                return merge(A, B, total, i + 1, j, t + 1);
            } else {
                total[t] = B[j];
                return merge(A, B, total, i, j + 1, t + 1);
            }
        } else if (i < A.length) {
            for (; i < A.length; i++) {
                total[t] = A[i];
                t++;
            }
        } else {
            for (; j < B.length; j++) {
                total[t] = B[j];
                t++;
            }
        }
        return total;
    }


}
