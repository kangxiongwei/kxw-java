package com.kxw.leetcode;

import java.math.BigDecimal;

/**
 * @author kangxiongwei
 * @date 2020-06-09 16:25
 */
public class ReverseIntegerSolution {

    public static void main(String[] args) {
        ReverseIntegerSolution solution = new ReverseIntegerSolution();
        int reverse = solution.reverse(1534236469);
        System.out.println(reverse);
        int reverse1 = solution.reverse(-123);
        System.out.println(reverse1);
    }

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int len = 0;
        int n = x;
        while (n != 0) {
            len++;
            n = n / 10;
        }
        int[] nums = new int[len];
        int[] powers = new int[len];
        int i = 0;
        int j = len;
        while (x != 0) {
            nums[i] = x % 10;
            powers[j - 1] = (int) Math.pow(10, j - 1);
            x = x / 10;
            i++;
            j--;
        }
        BigDecimal bg = new BigDecimal(0);
        for (int m = 0; m < len; m++) {
            BigDecimal pow = new BigDecimal(powers[len - m - 1]);
            BigDecimal value = new BigDecimal(nums[m]).multiply(pow);
            bg = bg.add(value);
            if (bg.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
                return 0;
            }
            if (bg.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
                return 0;
            }
        }
        return bg.intValue();
    }


}
