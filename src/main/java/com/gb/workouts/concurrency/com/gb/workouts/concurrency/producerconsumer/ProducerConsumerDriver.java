package com.gb.workouts.concurrency.com.gb.workouts.concurrency.producerconsumer;

/**
 * Created by gbalasubramanian on 17/02/19.
 */
public class ProducerConsumerDriver {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
