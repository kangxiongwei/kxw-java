package com.kxw.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kangxiongwei
 * @date 2020-04-20 22:20
 */
public class ThreadPoolApp {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit((Callable<String>) () -> null);
    }

}
