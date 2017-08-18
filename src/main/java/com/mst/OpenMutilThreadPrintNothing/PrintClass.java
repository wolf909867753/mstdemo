package com.mst.OpenMutilThreadPrintNothing;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wanglu-jf on 17/8/18.
 */
public class PrintClass {

    private String flag = "A";
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();//控制A线程运行
    Condition conditionB = lock.newCondition();//控制B线程运行
    Condition conditionC = lock.newCondition();//控制C线程运行
    public void PrintNameA(int i){//线程A的任务
        lock.lock();
        while (!"A".equals(flag)) {
            try {
                conditionA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try{
            System.out.print("A线程第"+i+"次输出---"+Thread.currentThread().getName());
            flag ="B";
            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    public void PrintNameB(int i){//线程B的任务
        lock.lock();
        while (!"B".equals(flag)) {
            try {
                conditionB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try{
            System.out.print("B线程第"+i+"次输出---"+Thread.currentThread().getName());
            flag ="C";
            conditionC.signal();
        }finally {
            lock.unlock();
        }
    }

    public void PrintNameC(int i){//线程C的任务
        lock.lock();
        while (!"C".equals(flag)) {
            try {
                conditionC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try{
            System.out.println("C线程第"+i+"次输出---"+Thread.currentThread().getName());
            flag ="A";
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }
}
