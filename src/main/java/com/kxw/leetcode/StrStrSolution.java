package com.kxw.leetcode;

/**
 * @author kangxiongwei
 * @date 2020-06-15 17:40
 */
public class StrStrSolution {

    public static void main(String[] args) {
        StrStrSolution solution = new StrStrSolution();
        int str = solution.strStr("mississippi", "pi");
        System.out.println(str);
    }


    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle) || needle.equals(haystack)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack)) {
            return -1;
        }

        int index = -1;
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                //找后面的子串
                if (i + needle.length() <= haystack.length()) {
                    String substring = haystack.substring(i, i + needle.length());
                    if (needle.equals(substring)) {
                        return i;
                    }
                }
            }
            i++;
        }
        return index;
    }


}
