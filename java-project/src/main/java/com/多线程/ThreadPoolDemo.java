package com.多线程;

import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author pengwei
 * @date 2021/1/24
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //一池N数量的线程。适用于短期异步小任务或者负载较轻的任务。
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        for (int i = 0; i <10 ; i++) {
            try{
            //TimeUnit.SECONDS.sleep(2);
            executorService3.execute(()->{
                System.out.println(Thread.currentThread().getName()+" run...");
            });
            }finally {
                executorService3.shutdown();
            }
        }

        //推荐使用
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,5,2L,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3)
        ,Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    }
}
