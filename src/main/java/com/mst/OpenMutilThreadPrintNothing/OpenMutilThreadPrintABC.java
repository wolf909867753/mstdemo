package com.mst.OpenMutilThreadPrintNothing;

/**
 * Created by wanglu-jf on 17/8/18.
 */
public class OpenMutilThreadPrintABC {
    public static void main(String[] args) {
        final PrintClass printClass = new PrintClass();
        new Thread(new Runnable() {
            public void run() {//线程A
                for( int i=1;i<=10;i++){
                    printClass.PrintNameA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {//线程B
            public void run() {
                for( int i=1;i<=10;i++){
                    printClass.PrintNameB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {//线程C
            public void run() {
                for( int i=1;i<=10;i++){
                    printClass.PrintNameC(i);
                }
            }
        },"C").start();
    }

}