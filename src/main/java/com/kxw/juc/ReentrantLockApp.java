package com.kxw.juc;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock源码
 *
 * @author kangxiongwei
 * @date 2020-04-17 02:48
 */
public class ReentrantLockApp {

    //共享变量
    private static int state;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition producer = lock.newCondition();
    private static Condition consumer = lock.newCondition();


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new InterruptStateThread());
            thread.start();
            thread.interrupt();
        }
    }

    private static void startStateThread() throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(new StateThread()).start();
        }
        Thread.sleep(1000);
        System.out.println(state);
    }

    private static void startProduceThread() {
        for (int i = 0; i < 5; i++) {
            new Thread(new ProduceStateThread()).start();
            new Thread(new ConsumerStateThread()).start();
        }
    }

    /**
     * 不带锁的线程，由于多个线程同时修改state变量
     * 可能线程A正在执行state += 1的操作，还未执行结束，线程B也读取了state变量，然后双方都给state + 1
     * 本来应该是加2，但是由于state一样，变成了加1
     */
    static class StateThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                state = state + 1;
            }
        }
    }


    /**
     * 带锁的线程，由于线程A执行过程中，代码被锁住，其他线程无法获取到锁，因此最终数据会一致
     */
    static class LockStateThread implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 1000; i++) {
                    state = state + 1;
                }
            } finally {
                lock.unlock();
            }
        }

    }

    /**
     * 锁的打断功能
     */
    static class InterruptStateThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                lock.lockInterruptibly();
                int millis = new Random().nextInt(10000);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    /**
     * 利用锁条件，实现生产者和消费者，这是生产者线程
     */
    static class ProduceStateThread implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                //生产最多5000个，满了就等待
                while (state == 5000) {
                    producer.await();
                }
                //每个线程最多生产1000个
                for (int i = 0; i < 1000; i++) {
                    state += 1;
                }
                System.out.println(Thread.currentThread().getName() + "---> 生产完毕，当前数量为：" + state);
                consumer.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 利用锁条件，实现生产者和消费者，这是消费者线程
     */
    static class ConsumerStateThread implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                while (state == 0) {
                    consumer.await();
                }
                for (int i = 0; i < 1000; i++) {
                    state -= 1;
                }
                System.out.println(Thread.currentThread().getName() + "---> 消费完毕，当前数量为：" + state);
                producer.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }


}
