package com.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author pengwei
 * @date 2021/1/24
 */
class MyCallableDe implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("myCallable  come in .....");
        return 512;
    }
}


public class CallableDemo {

    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask(new MyCallableDe());
        new Thread(futureTask, "t1").start();
        //temp放在前面是等主线程执行完再获取值；
        //temp放在前面是等futureTask线程执行完再执行主线程；
        int temp=100;
        int result = (int) futureTask.get();
        //int temp=100;
        System.out.println("result:" + (result+temp));


    }
}


