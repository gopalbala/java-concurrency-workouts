package com.gb.workouts.concurrency.executor;

import java.util.concurrent.Callable;

public class Called implements Callable {

    @Override
    public Object call() throws Exception {
        return Thread.currentThread().getId() + ":executing";
    }
}
