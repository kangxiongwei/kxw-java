package com.kxw.leetcode;

/**
 * 在一个长字符串中找一个子字符串是否存在，有，返回index，没有，返回-1。子字符串要求连续，但不在乎内部字符的顺序
 *
 * @author kangxiongwei
 * @date 2020-04-10 19:56
 */
public class SubStringSolution {


    public static void main(String[] args) {
        SubStringSolution solution = new SubStringSolution();
        int string = solution.findSubString("abddsdsdsdsdss", "sdd");
        System.out.println(string);
    }


    public int findSubString(String str, String word) {
        int i = 0;
        while (i < str.length() - word.length()) {
            String subString = str.substring(i, i + word.length());
            boolean eq = equal(word, subString);
            if (eq) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean equal(String str1, String str2) {
        int a = 0;
        for (char str : str1.toCharArray()) {
            a += str;
        }
        int b = 0;
        for (char str : str2.toCharArray()) {
            b += str;
        }
        return a == b;
    }


}
