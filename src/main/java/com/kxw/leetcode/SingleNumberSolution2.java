package com.kxw.leetcode;

/**
 * 现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。你需要找出只出现一次的元素
 *
 * @author kangxiongwei
 * @date 2020-04-13 17:57
 */
public class SingleNumberSolution2 {

    public static void main(String[] args) {
        SingleNumberSolution2 solution = new SingleNumberSolution2();
        int number = solution.singleNumber(new int[]{-5, 2, 2, 2, 3, 3, 3});
        System.out.println(number);
    }


    /**
     * 对int类型的二进制，每一位数字进行相加然后对3取余，得到的结果，就是唯一的那个值
     *
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int res = 0;
        //每一位对3取余，计算第几位可以利用1左移i位获得
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int value : A) {
                sum += (value >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }


}
