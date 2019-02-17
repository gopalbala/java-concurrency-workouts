package com.gb.workouts.concurrency.com.gb.workouts.concurrency.producerconsumer;

import java.util.LinkedList;

/**
 * Created by gbalasubramanian on 16/02/19.
 */
public class ProducerConsumer {
    LinkedList<Integer> linkedList = new LinkedList<>();
    int capacity = 5;
    Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (linkedList.size() == capacity) {
                    lock.wait();
                }
                value++;
                linkedList.add(value);
                System.out.println("Produced " + value);
                Thread.sleep(1000);
                lock.notify();

            }
        }
    }

    public void consume() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (linkedList.size() == 0) {
                    lock.wait();
                }
                System.out.println("Consumed " + linkedList.removeFirst());
                Thread.sleep(1000);
                lock.notify();
            }
        }
    }
}
