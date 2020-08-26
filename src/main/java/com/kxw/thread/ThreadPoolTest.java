package com.kxw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kangxiongwei
 * @date 2020-06-18 10:55
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.submit(() -> System.out.println("xxxxx"));
        threadPool.execute(() -> System.out.println("yyyyyyy"));
    }



}
