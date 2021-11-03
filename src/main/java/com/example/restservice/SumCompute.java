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

class ThreadCompute implements Runnable{
    public Thread t;
    private String threadName;
    SumCompute SC;
    private int sumNumber;
    private int result;

    public int getResult() {
        return result;
    }

    public String getThreadName(){
        return threadName;
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
        try {
            // Make thread sleep
            Thread.sleep(1500);
            System.out.println("State of thread after calling .sleep() on it: " + t.getState() + ", " + threadName);
            Thread.sleep(200);
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
            System.out.println("State of thread after creation: " + t.getState() + ", " + threadName);

            // Start is called on thread which executes a call to run() method that resides inside the thread object.
            // Since this points to the class itself, it will call run() in SumCompute
            t.start();
            System.out.println("State of thread after calling .start() on it: " + t.getState() + ", " + threadName);
        }
    }
}
