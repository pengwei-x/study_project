package com.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序执行，实现 a,b,c三个线程依次执行
 * AA打印5遍，BB打印6遍，CC打印8遍
 * 循环2遍
 * * @author pengwei
 *
 * @date 2021/1/22
 */

class ShareResoure {
    /**
     * 1 a
     * 2 b
     * 3 c
     */
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition a1 = lock.newCondition();
    private Condition a2 = lock.newCondition();
    private Condition a3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (flag != 1) {
                a1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
            flag = 2;
            //通知b
            a2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print6() {
        lock.lock();
        try {
            while (flag != 2) {
                a2.await();
            }
            for (int i = 1; i <= 6; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
            flag = 3;
            //通知b
            a3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print8() {
        lock.lock();
        try {
            while (flag != 3) {
                a1.await();
            }
            for (int i = 1; i <= 8; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
            flag = 1;
            //通知b
            a1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockTest {


    public static void main(String[] args) {
        ShareResoure shareResoure = new ShareResoure();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shareResoure.print5();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shareResoure.print6();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                shareResoure.print8();
            }
        }, "CC").start();
    }


}


