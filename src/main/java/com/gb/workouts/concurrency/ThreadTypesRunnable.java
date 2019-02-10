package com.gb.workouts.concurrency;

import java.util.Random;

/**
 * Created by gbalasubramanian on 10/02/19.
 */
public class ThreadTypesRunnable extends Random implements Runnable {

    final private String threadType;

    public ThreadTypesRunnable(String threadType) {
        this.threadType = threadType;
    }

    private final int MAX_ITERATIONS = 100000000;

    private int computeGCD(int number1,
                           int number2) {
        // Basis case.
        if (number2 == 0)
            return number1;
        // Recursive call.
        return computeGCD(number2,
                number1 % number2);
    }

    @Override
    public void run() {
        final String threadString =
                " with "
                        + threadType
                        + " thread id "
                        + Thread.currentThread();


        try {
            // Iterate for the given # of iterations.
            for (int i = 0; i < MAX_ITERATIONS; ++i) {
                // Generate two random numbers.
                int number1 = this.nextInt();
                int number2 = this.nextInt();

                // Print results every 10 million iterations.
                if ((i % 10000000) == 0)
                    System.out.println("In run()"
                            + threadString
                            + " the GCD of "
                            + number1
                            + " and "
                            + number2
                            + " is "
                            + computeGCD(number1,
                            number2));
            }
        }
        finally {
            System.out.println("Leaving run() "
                    + threadString);
        }
    }
}
