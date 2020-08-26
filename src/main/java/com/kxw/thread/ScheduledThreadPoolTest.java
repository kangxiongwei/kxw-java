package com.kxw.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kangxiongwei
 * @date 2020/8/10 3:29 下午
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前时间：" + System.currentTimeMillis());
            }
        }, 3, 3, TimeUnit.SECONDS);
    }


}
