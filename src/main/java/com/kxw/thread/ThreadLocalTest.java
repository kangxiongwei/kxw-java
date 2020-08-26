package com.kxw.thread;

/**
 * @author kangxiongwei
 * @date 2020/8/12 5:19 下午
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                THREAD_LOCAL.set("thread local 1");
                System.out.println(THREAD_LOCAL.get());
            } finally {
                THREAD_LOCAL.remove();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                THREAD_LOCAL.set("thread local 2");
                System.out.println(THREAD_LOCAL.get());
            } finally {
                THREAD_LOCAL.remove();
            }
        });
        t1.start();
        t2.start();
    }

}
