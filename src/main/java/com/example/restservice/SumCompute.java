package com.example.restservice;

class SumCompute {
    public int computeSum(int sumNumber){
        int sum = 0;
        for(int i=sumNumber; i>0; i--) {
            sum = sum + i;
        }
        return sum;
    }
}

class ThreadCompute implements Runnable {
    private Thread t;
    private String threadName;
    SumCompute SC;
    private int sumNumber;
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Thread gett() {
        return t;
    }

    ThreadCompute ( String name, int number, SumCompute sc) {
        SC = sc;
        threadName = name;
        sumNumber = number;
        System.out.println("Creating thread:" + threadName);
    }

    @Override
    public void run() {
        synchronized (SC){
            System.out.println("Thread: " + threadName + ", sum: " + SC.computeSum(sumNumber));
        }
        System.out.println("Running thread:" + threadName);
//        int sum = 0;
        try {
//            for(int i=sumNumber; i>0; i--) {
//                sum = sum + i;
//            }
//            System.out.println("Thread: " + threadName + ", sum: " + sum);
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
        setResult(SC.computeSum(sumNumber));
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
    public void join() {
        System.out.println("Join thread: " + threadName);
        try {
            t.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
