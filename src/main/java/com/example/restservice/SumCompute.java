package com.example.restservice;

public class SumCompute implements Runnable {
    private Thread t;
    private String threadName;

    SumCompute ( String name) {
        threadName = name;
        System.out.println("Creating thread:" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running thread:" + threadName);
        try {
            for(int i=3; i>0; i--) {
                System.out.println("Thread: " + threadName + "," + i);
                // Make thread sleep
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted");
        }
        System.out.println("Thread: " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting thread: " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
