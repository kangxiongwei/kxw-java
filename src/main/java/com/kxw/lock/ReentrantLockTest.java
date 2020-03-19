package com.kxw.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kangxiongwei
 * @date 2020-02-26 16:28
 */
public class ReentrantLockTest {

    private Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        final ReentrantLockTest client = new ReentrantLockTest();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                client.test();
            }
        };
        thread1.setName("t1");
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                client.test();
            }
        };
        thread2.setName("t2");
        thread2.start();
    }

    public void test() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
