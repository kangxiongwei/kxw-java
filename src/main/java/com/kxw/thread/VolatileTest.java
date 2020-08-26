package com.kxw.thread;

import java.util.Random;

/**
 * @author kangxiongwei
 * @date 2020-07-29 16:08
 */
public class VolatileTest {

    private volatile int a;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        new Thread(new ThreadB(test)).start();
        new Thread(new ThreadA(test)).start();
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return this.a;
    }

    public static class ThreadA implements Runnable {

        private VolatileTest test;

        public ThreadA(VolatileTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test.setA(i);
            }
        }
    }

    public static class ThreadB implements Runnable {

        private VolatileTest test;

        public ThreadB(VolatileTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(test.getA());
            }
        }
    }

}
