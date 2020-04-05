package com.kxw.leetcode;

/**
 * 数组中只有一个元素出现一次，其余出现两次，找到这个数字
 *
 * @author kangxiongwei
 * @date 2020-04-05 12:47
 */
public class SingleNumberSolution {

    public static void main(String[] args) {
        SingleNumberSolution solution = new SingleNumberSolution();
        int number = solution.singleNumber(new int[]{1, 1, 2, 3, 3});
        System.out.println(number);
    }

    /**
     * 异或
     *
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        if (A == null || A.length <= 0) {
            return 0;
        }
        int value = A[0];
        for (int i = 1; i < A.length; i++) {
            value = value ^ A[i];
        }
        return value;
    }


}
