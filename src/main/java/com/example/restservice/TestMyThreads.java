package com.example.restservice;

public class TestMyThreads {
    public static void main(String args[]) {
        SumCompute sumCompute1 = new SumCompute("Thread-1");
        sumCompute1.start();
        SumCompute sumCompute2 = new SumCompute("Thread-2");
        sumCompute2.start();
    }
}
