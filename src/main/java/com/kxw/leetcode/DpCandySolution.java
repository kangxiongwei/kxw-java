package com.kxw.leetcode;

import java.util.Arrays;

/**
 * 有N个小朋友站在一排，每个小朋友都有一个评分
 * 你现在要按以下的规则给孩子们分糖果：
 * 每个小朋友至少要分得一颗糖果
 * 分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
 * 你最少要分发多少颗糖果？
 *
 * @author kangxiongwei
 * @date 2020-04-14 18:14
 */
public class DpCandySolution {

    public static void main(String[] args) {
        DpCandySolution solution = new DpCandySolution();
        int candy = solution.candy(new int[]{4, 2, 3, 4, 1});
        System.out.println(candy);
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        this.allocate(ratings, candies);
        return Arrays.stream(candies).sum();
    }

    private void allocate(int[] ratings, int[] candies) {
        int length = ratings.length;
        if (length == 1) {
            candies[0] = 1;
            return;
        }
        //从左向右扫描
        for (int i = 1; i < length; i++) {
            if (candies[i - 1] == 0) {
                candies[i - 1] = 1;
            }
            if (candies[i] == 0) {
                candies[i] = 1;
            }
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        //从右向左扫描
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
    }


}
