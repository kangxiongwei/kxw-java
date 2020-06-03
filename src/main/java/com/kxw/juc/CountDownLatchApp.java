package com.kxw.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author kangxiongwei
 * @date 2020-04-18 00:41
 */
public class CountDownLatchApp {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new CountDownLatchThread(latch));
            thread.setName("线程" + i);
            thread.start();
        }
        latch.await();
        System.out.println("主线程");
    }

    static class CountDownLatchThread implements Runnable {

        private CountDownLatch latch;

        public CountDownLatchThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                int millis = new Random().nextInt(1000);
                Thread.sleep(millis);
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }

}
