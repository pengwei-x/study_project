package com.多线程;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁
 *
 * @author pengwei
 * @date 2021/1/24
 */

class HoldLock implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("11");
            System.out.println(Thread.currentThread().getName() + "自己持有" + lockA + "尝试获取" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println("22");
                System.out.println(Thread.currentThread().getName() + "自己持有" + lockB + "尝试获取" + lockA);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "LockA";
        String lockB = "LockB";
//        new Thread(new HoldLock(lockA, lockB), "AA").start();
//        new Thread(new HoldLock(lockB, lockA), "BB").start();

        new AtomicInteger().getAndIncrement();
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
//        objectObjectConcurrentHashMap.put();

        new ReentrantLock().lock();

    }
}
