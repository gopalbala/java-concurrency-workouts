package com.gb.workouts.concurrency.Sequences;

/**
 * Created by gbalasubramanian on 16/02/19.
 */
public class SequeceShared {
    int number = 1;
    int numberOfThreads;
    int numInSequence;

    public SequeceShared(int numberOfThreads, int numInDequence) {
        this.numberOfThreads = numberOfThreads;
        this.numInSequence = numInDequence;
    }

    public void printSequence(int seq) {
        synchronized (this) {
            while (number < numInSequence - 1) {
                while (number % numberOfThreads != seq) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " - " + number++);
                this.notifyAll();
            }
        }
    }

}
