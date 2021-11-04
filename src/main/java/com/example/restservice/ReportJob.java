package com.example.restservice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ReportJob implements Runnable{
    private Thread t;
    private String threadName;
    private ArrayList<Integer> results;
    private ArrayList<ThreadCompute> threads;

    public ArrayList<Integer> getResults() {
        return results;
    }

    ReportJob () {
        threadName = "thread-report";
    }
    private void createThreads() {
        // Create thread names
        int threadsCount = 6;
        ArrayList<String> threadNames = new ArrayList<>(threadsCount);
        for (int i=1; i <= threadsCount; i++) {
            threadNames.add("thread-" + i);
        }
        SumCompute sc = new SumCompute();
        int sumNumber = 3;
        threads = new ArrayList<>(threadsCount);
        for (String element: threadNames){
            ThreadCompute threadCompute = new ThreadCompute(element, sumNumber, sc);
            threads.add(threadCompute);
            threadCompute.start();
            System.out.println("State of thread after being calling .start() by other: " + threadCompute.gett().getState() + ", " + element);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted");
            }
            System.out.println("State of thread after calling .sleep() on it 1: " + threadCompute.gett().getState() + ", " + element);
            sumNumber++;
        }
    }

    private void printResults() {
        results = new ArrayList<>(threads.size());
        for (ThreadCompute i: threads) {
            System.out.println("Thread result: " + i.getResult() + ", " + i.getThreadName());
            results.add(i.getResult());
        }
        System.out.println("Report Job results of threads:" + results);
    }

    @Override
    public void run() {
        System.out.println("Running thread:" + threadName);

        // Report job is also master thread
        // Create all threads
        this.createThreads();

        try {
            for (ThreadCompute element: threads) {
                // Join thread-report on all other threads, such that it will wait until they die before exiting
                element.gett().join();
                System.out.println("State of thread after being calling .join() by other: " + element.gett().getState() + ", " + element.getThreadName());
                System.out.println("State of thread after calling .join() on it: " + t.getState() + ", " + threadName);
            }
        } catch (Exception e) {
            System.out.println("Interrupted");
        }

        printResults();
        gc();
        System.out.println("Thread: " + threadName + " exiting.");
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

    private void gc() {
        threads = null;
    }

}
