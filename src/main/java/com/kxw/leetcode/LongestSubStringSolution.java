package com.kxw.leetcode;

import java.util.*;

/**
 * 给定一个字符串，找出最长的不具有重复字符的子串的长度。例如，“abcabcbb”不具有重复字符的最长子串是“abc”，长度为3。对于“bbbbb”，最长的不具有重复字符的子串是“b”，长度为1。
 *
 * @author kangxiongwei
 * @date 2020-06-04 19:02
 */
public class LongestSubStringSolution {

    public static void main(String[] args) {
        LongestSubStringSolution solution = new LongestSubStringSolution();
        int length = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int left = 0;
        int next;
        PriorityQueue<Set<Character>> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.size(), o1.size()));
        while (left < s.length()) {
            //从左向右，记录窗口中的字符
            Set<Character> window = new HashSet<>();
            window.add(s.charAt(left));
            next = left + 1;
            while (next < s.length()) {
                Character nextChar = s.charAt(next);
                if (!window.contains(nextChar)) {
                    window.add(nextChar);
                    next++;
                } else {
                    break;
                }
            }
            queue.add(window);
            left++;
        }
        Set<Character> peek = queue.peek();
        return peek != null ? peek.size() : 0;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int rk = -1, ans = 0;
        int length = s.length();
        Set<Character> window = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                window.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !window.contains(s.charAt(rk + 1))) {
                window.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
