package com.kxw.lambda;

/**
 * @author kangxiongwei
 * @date 2020/8/17 4:00 下午
 */
public class NumberOperationTest {

    public static void main(String[] args) {
        int x = 8;
        int y = 3;
        NumberOperation operation = (a, b) -> a + b;
        System.out.println(operation.opt(x, y));
        NumberOperation opt2 = (a, b) -> a * b;
        System.out.println(opt2.opt(x, y));
    }

}
