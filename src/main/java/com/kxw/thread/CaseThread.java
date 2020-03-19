package com.kxw.thread;

/**
 * @author kangxiongwei
 * @date 2020-03-19 09:35
 */
public class CaseThread extends Thread {

    public static void main(String[] args) {
        CaseThread thread = new CaseThread();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}
