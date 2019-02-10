package com.gb.workouts.concurrency;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;

/**
 * Created by gbalasubramanian on 10/02/19.
 */
public class ThreadTypes extends Thread {
    final String threadType;

    public ThreadTypes(String threadType) {
        if (threadType.equals("daemon"))
            setDaemon(true);
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

    public void run() {
        final String threadString =
                " with "
                        + threadType
                        + " thread id "
                        + Thread.currentThread();

        Random random = new Random();

        try {
            // Iterate for the given # of iterations.
            for (int i = 0; i < MAX_ITERATIONS; ++i) {
                // Generate two random numbers.
                int number1 = random.nextInt();
                int number2 = random.nextInt();

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
