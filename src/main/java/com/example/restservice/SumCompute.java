package com.example.restservice;

public class SumCompute implements Runnable {
    private Thread t;
    private String threadName;
    private int sumNumber;
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    SumCompute ( String name, int number) {
        threadName = name;
        sumNumber = number;
        System.out.println("Creating thread:" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running thread:" + threadName);
        try {
            int sum = 0;
            for(int i=sumNumber; i>0; i--) {
                sum = sum + i;
            }
            setResult(sum);
            System.out.println("Thread: " + threadName + ", sum: " + sum);
            // Make thread sleep
            Thread.sleep(50);

//            for(int i=3; i>0; i--) {
//                System.out.println("Thread: " + threadName + "," + i);
//                // Make thread sleep
//                Thread.sleep(50);
//            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted");
        }
        System.out.println("Thread: " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting thread: " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            // Start is called on thread which executes a call to run() method that resides inside the thread object.
            // Since this points to the class itself, it will call run() in SumCompute
            t.start();
        }
    }

}
