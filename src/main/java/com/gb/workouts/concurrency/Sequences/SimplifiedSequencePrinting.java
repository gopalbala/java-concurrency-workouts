package com.gb.workouts.concurrency.Sequences;

/**
 * Created by gbalasubramanian on 16/02/19.
 */
public class SimplifiedSequencePrinting {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SimplifiedSequnce(1,3,10), "T1");
        Thread thread2 = new Thread(new SimplifiedSequnce(2,3,10), "T2");
        Thread thread3 = new Thread(new SimplifiedSequnce(0,3,10), "T3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
