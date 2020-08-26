package com.kxw.leetcode;

/**
 * @author kangxiongwei
 * @date 2020-06-15 16:34
 */
public class LongestCommonPrefixSolution {

    public static void main(String[] args) {
        LongestCommonPrefixSolution solution = new LongestCommonPrefixSolution();
        String[] strings = new String[]{"floor", "flight", "flow"};
        String prefix = solution.longestCommonPrefix(strings);
        System.out.println(prefix);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            //拿第一个字符串的字符和其他字符串对比
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String other = strs[j];
                if (i == other.length() || other.charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
