package com.kxw.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一组单词dict，判断s是否可以用空格分割成一个单词序列，使得单词序列中所有的单词都是dict中的单词（序列可以包含一个或多个单词）。
 * 例如:
 * 给定s=“leetcode”；
 * dict=["leet", "code"].
 * 返回true，因为"leetcode"可以被分割成"leet code".
 *
 * @author kangxiongwei
 * @date 2020-04-09 12:56
 */
public class WordBreakSolution {

    public static void main(String[] args) {
        WordBreakSolution solution = new WordBreakSolution();
        String str = "aaaaaaa";
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        boolean wordBreak = solution.wordBreak(str, dict);
        System.out.println(wordBreak);
    }


    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        boolean[] flag = new boolean[length + 1];
        flag[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (flag[j] && dict.contains(word)) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[length];
    }


}
