package com.gb.workouts.concurrency;

/**
 * Created by gbalasubramanian on 10/02/19.
 */
public class ThreadTypesTest {
    public static void main(String[] args) {
        ThreadTypes threadTypesTest = new ThreadTypes("daemon");
        threadTypesTest.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException x) {}

        System.out.println("Leaving main()");
    }
}
