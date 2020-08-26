package com.kxw.oop;

import org.openjdk.jol.info.ClassLayout;

/**
 * 虚拟机参数：
 * -XX:-UseCompressedClassPointers -XX:-UseCompressedOops
 *
 * @author kangxiongwei
 * @date 2020-07-28 16:08
 */
public class OopTest {

    public static void main(String[] args) {
        Object lock = new Object();
        System.out.println("加锁前**********************");
        String layout0 = ClassLayout.parseInstance(lock).toPrintable();
        System.out.println(layout0);
        System.out.println("***********加锁时***********");
        synchronized (lock) {
            // -XX:BiasedLockingStartupDelay=0 偏向锁延时
            String layout1 = ClassLayout.parseInstance(lock).toPrintable();
            System.out.println(layout1);
        }
        System.out.println("*********************释放锁后*");
        String layout2 = ClassLayout.parseInstance(lock).toPrintable();
        System.out.println(layout2);
    }


}
