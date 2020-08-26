package com.kxw.leetcode;

import javax.swing.plaf.SliderUI;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739.每日温度
 *
 * @author kangxiongwei
 * @date 2020-06-11 17:05
 */
public class DailyTemperaturesSolution {

    public static void main(String[] args) {
        DailyTemperaturesSolution solution = new DailyTemperaturesSolution();
        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] days = solution.dailyTemperatures2(T);
        Arrays.stream(days).forEach(System.out::println);
    }

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];     //当前温度
            int j = i + 1;
            while (j < T.length) {
                if (T[j] > temperature) {
                    result[i] = j - i;
                    break;
                }
                j++;
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];     //当前温度
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

}
