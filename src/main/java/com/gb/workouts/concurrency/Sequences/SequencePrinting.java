package com.gb.workouts.concurrency.Sequences;

/**
 * Created by gbalasubramanian on 16/02/19.
 */
public class SequencePrinting {
    public static void main(String[] args) {
        SequeceShared sequeceShared = new SequeceShared( 3, 10);
        Thread t1 = new Thread(new Sequence(sequeceShared, 0), "T1");
        Thread t2 = new Thread(new Sequence(sequeceShared, 1), "T2");
        Thread t3 = new Thread(new Sequence(sequeceShared, 2), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
