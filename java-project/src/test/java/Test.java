import jdk.nashorn.internal.ir.CallNode;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author pengwei
 * @date 2021/1/21
 */
public class Test {
    AtomicReference<Thread > atomicReference=new AtomicReference<>();

    public void muLock() throws Exception{
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        CountDownLatch countDownLatch=new CountDownLatch(6);
        countDownLatch.countDown();
        Semaphore semaphore = new Semaphore(6);
        //semaphore.acquire();
        semaphore.release();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        //等待
        condition.await();
        //唤醒
        condition.signal();



        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"--"+"come in");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName()+"--"+"out to");
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayList<>();
    }
}
