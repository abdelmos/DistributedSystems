package com.company;

public class TaskA implements Runnable{
    private Counter cnt;

    public TaskA(Counter cnt)
    {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){System.out.println(e);}
        for(int i=0; i<1000000; i++) {
            cnt.increment();

        }

    }
}
