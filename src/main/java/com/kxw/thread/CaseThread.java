package com.kxw.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author kangxiongwei
 * @date 2020-03-19 09:35
 */
public class CaseThread extends Thread {

    public static void main(String[] args) throws Exception {
        CaseThread thread = new CaseThread();
        thread.start();

        Runnable runnable = new CaseRunnable();
        new Thread(runnable).start();

        Callable<String> callable = new CaseCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    /**
     * 通过继承Thread实现线程
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 通过Runnable实现线程
     */
    static class CaseRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }

    }

    /**
     * 通过Callable实现线程
     */
    static class CaseCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }


}
