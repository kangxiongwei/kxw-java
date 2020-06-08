package com.kxw.leetcode;

import java.util.*;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {2, 7, 11, 15},目标值为9
 * 输出 ndex1=1, index2=2
 *
 * @author kangxiongwei
 * @date 2020-06-04 17:21
 */
public class TwoSumSolution {

    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] ints = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ints[0] + "   " + ints[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= numbers.length; i++) {
            //当前数字
            int num = numbers[i - 1];
            //之前的数字
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }
        return null;
    }


}
