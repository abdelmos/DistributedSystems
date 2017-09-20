package com.company;

public class Main {

    public static void programA (int nThreads)
    {
        final long startTime = System.currentTimeMillis();
        Counter cnt = new Counter();
        Thread [] threads = new Thread[nThreads];
        //intialize threads && start
        for (int i =0; i< nThreads;i++){
            threads[i] = new Thread(new TaskA(cnt));
            threads[i].start();
        }

        //start threads
        try{
            for (int i = 0; i <nThreads; i++){
                threads[i].join();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Final Counter = " + cnt.getCounter());
        System.out.println("Total execution time: " + (endTime - startTime) );

    }
    public static void progaramB (int nThreads){
        final long startTime = System.currentTimeMillis();
        Counter cnt = new Counter();
        Thread [] threads = new Thread[nThreads];
        //intialize threads && start
        for (int i =0; i< nThreads;i++){
            threads[i] = new Thread(new TaskB(cnt));
            threads[i].start();
        }

        //start threads
        try{
            for (int i = 0; i <nThreads; i++){
                threads[i].join();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Final Counter = " + cnt.getCounter());
        System.out.println("Total execution time: " + (endTime - startTime) );

    }

    public static void progaramC (int nThreads){
        final long startTime = System.currentTimeMillis();
        Counter cnt = new Counter();
        TaskA taskA = new TaskA(cnt);
        //intialize threads && start
        for (int i =0; i< nThreads;i++){
            taskA.run();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Final Counter = " + cnt.getCounter());
        System.out.println("Total execution time: " + (endTime - startTime) );

    }

    public static void main(String[] args) {

        String programToRun = args[0];
        int nThreads = Integer.parseInt(args[1]);
        switch (programToRun){
            case "A":
                System.out.println("Program A will Run with  " + nThreads + " threads");
                programA( nThreads);
                return;
            case "B":
                System.out.println("Program B will Run with  " + nThreads + " threads");
                progaramB(nThreads);
                return;
            case "C":
                System.out.println("Program c will Run with 1 thread " + nThreads + " times");
                progaramC(nThreads);
                return;
            default:
                System.out.println("Invalid program");
        }

    }
}
