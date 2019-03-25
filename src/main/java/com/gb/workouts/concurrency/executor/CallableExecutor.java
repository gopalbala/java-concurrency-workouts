package com.gb.workouts.concurrency.executor;

import java.util.concurrent.*;

public class CallableExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Single thread");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            Future<String> future = executorService.submit(new Called());
            System.out.println(future.get());
        }
        executorService.shutdown();
        System.out.println("Cached thread pool");
        executorService = Executors.newCachedThreadPool();
        for (int i =0;i<10;i++){
            Future<String> future = executorService.submit(new Called());
            System.out.println(future.get());
        }

        executorService.shutdown();

        System.out.println("Fixed thread pool");

        executorService = Executors.newFixedThreadPool(4);
        for (int i =0;i<10;i++){
            Future<String> future = executorService.submit(new Called());
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
