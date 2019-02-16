package com.gb.workouts.concurrency.Sequences;

/**
 * Created by gbalasubramanian on 16/02/19.
 */
public class SimplifiedSequnce implements Runnable{
    static int num = 1;
    int currentThread;
    int numberOfThreads;
    int maxNum;

    static Object lock = new Object();

    public SimplifiedSequnce( int currentThread,int numberOfThreads, int maxNum) {
        this.numberOfThreads = numberOfThreads;
        this.currentThread = currentThread;
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (num < maxNum) {
                while (num % numberOfThreads != currentThread ){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("current Thread : " + Thread.currentThread().getName() + " : " + num);
                num = num + 1;
                lock.notifyAll();
            }
        }
    }

}
