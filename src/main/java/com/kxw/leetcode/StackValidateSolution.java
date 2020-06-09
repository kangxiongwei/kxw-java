package com.kxw.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 946.验证栈序列
 *
 * @author kangxiongwei
 * @date 2020-06-09 14:51
 */
public class StackValidateSolution {

    public static void main(String[] args) {
        StackValidateSolution solution = new StackValidateSolution();
        int[] pushed = new int[]{2, 1, 0};
        int[] popped = new int[]{1, 2, 0};
        boolean sequences = solution.validateStackSequences(pushed, popped);
        System.out.println(sequences);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer pop : popped) {
            queue.add(pop);
        }
        for (Integer pushNum : pushed) {
            //从队列获取头部元素，并删除这个元素
            stack.push(pushNum);
            while (!queue.isEmpty() && !stack.isEmpty() && queue.peek().equals(stack.peek())) {
                stack.pop();
                queue.remove();
            }
        }
        //尝试释放栈内容
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            Integer pop = stack.pop();
            if (!poll.equals(pop)) {
                break;
            }
        }

        return queue.isEmpty();
    }

}
