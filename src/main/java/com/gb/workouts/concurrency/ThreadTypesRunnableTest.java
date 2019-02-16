package com.gb.workouts.concurrency;

/**
 * Created by gbalasubramanian on 10/02/19.
 */
public class ThreadTypesRunnableTest {
    public static void main(String[] args) {
        ThreadTypesRunnable threadTypesRunnable = new ThreadTypesRunnable("daemon");
        Thread thread = new Thread(threadTypesRunnable);
//        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException ie){

        }
        System.out.println("Leaving main");

    }
}
