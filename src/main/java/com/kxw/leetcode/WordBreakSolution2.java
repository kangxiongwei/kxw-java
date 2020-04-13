package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串s和一组单词dict，在s中添加空格将s变成一个句子，使得句子中的每一个单词都是dict中的单词
 * 返回所有可能的结果
 * 例如：给定的字符串s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 *
 * 返回的结果为["cats and dog", "cat sand dog"].
 *
 * @author kangxiongwei
 * @date 2020-04-09 12:58
 */
public class WordBreakSolution2 {

    public static void main(String[] args) {
        WordBreakSolution2 solution = new WordBreakSolution2();
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        ArrayList<String> list = solution.wordBreak("catsanddog", dict);
        System.out.println(list);
    }


    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> words = new ArrayList<>();
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
        return words;
    }




}
