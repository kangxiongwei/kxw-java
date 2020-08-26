package com.kxw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题46. 把数字翻译成字符串
 *
 * @author kangxiongwei
 * @date 2020-06-09 17:48
 */
public class NumberTranslateSolution {


    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        int trans = 0;
        List<Integer> translate = translate(num);
        return 0;
    }

    /**
     * 分解某个数字
     *
     * @param num
     * @return
     */
    private List<Integer> translate(int num) {
        List<Integer> list = new ArrayList<>();
        int last = num % 10;    //个位数
        list.add(last);
        if (num >= 10 && (num % 100) <= 25) {
            list.add(num % 100);
        }
        return list;
    }

}
