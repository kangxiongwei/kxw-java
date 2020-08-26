package com.kxw.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author kangxiongwei
 * @date 2020-07-29 16:49
 */
public class InterruptTest {

    public static void main(String[] args) throws Exception {
        Thread sleepThread = new Thread(new SleepThread(), "SleepThread");
        //sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyThread(), "BusyThread");
        //busyThread.setDaemon(true);

        sleepThread.start();
        //busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        System.out.println("SleepThread pre interrupted is " + sleepThread.isInterrupted());
        sleepThread.interrupt();
        //busyThread.interrupt();
        System.out.println("SleepThread after interrupted is " + sleepThread.isInterrupted());
        //System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }

    public static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static class BusyThread implements Runnable {

        @Override
        public void run() {
            while (true) {}
        }
    }

}
