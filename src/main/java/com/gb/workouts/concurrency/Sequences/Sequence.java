package com.gb.workouts.concurrency.Sequences;

/**
 * Created by gbalasubramanian on 16/02/19.
 */
public class Sequence implements Runnable {

    SequeceShared sequeceShared;
    int result;

    public Sequence(SequeceShared sequeceShared, int result) {
        this.sequeceShared = sequeceShared;
        this.result = result;
    }

    @Override
    public void run() {
        sequeceShared.printSequence(result);
    }
}
