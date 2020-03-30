package com.kxw.leetcode;

import java.util.Stack;

/**
 * 逆波兰式
 *
 * @author kangxiongwei
 * @date 2020-03-30 22:49
 */
public class ReversePolishNotationSolution {

    public static void main(String[] args) {
        ReversePolishNotationSolution solution = new ReversePolishNotationSolution();
        int rpn = solution.evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(rpn);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        int value = 0;
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                String val2 = stack.pop();
                String val1 = stack.pop();
                value = Integer.parseInt(val1) + Integer.parseInt(val2);
                stack.push(String.valueOf(value));
            } else if ("-".equals(token)) {
                String val2 = stack.pop();
                String val1 = stack.pop();
                value = Integer.parseInt(val1) - Integer.parseInt(val2);
                stack.push(String.valueOf(value));
            } else if ("*".equals(token)) {
                String val2 = stack.pop();
                String val1 = stack.pop();
                value = Integer.parseInt(val1) * Integer.parseInt(val2);
                stack.push(String.valueOf(value));
            } else if ("/".equals(token)) {
                String val2 = stack.pop();
                String val1 = stack.pop();
                value = Integer.parseInt(val1) / Integer.parseInt(val2);
                stack.push(String.valueOf(value));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }


}
