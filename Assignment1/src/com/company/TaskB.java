package com.company;

public class TaskB implements Runnable{
    private Counter cnt;

    public TaskB(Counter cnt)
    {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        for(int i=0; i<1000000; i++) {
            cnt.safeIncrement();

        }

    }
}
