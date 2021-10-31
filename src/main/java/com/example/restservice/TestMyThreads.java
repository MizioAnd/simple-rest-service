package com.example.restservice;

public class TestMyThreads {
    public static void main(String args[]) {
        SumCompute sumCompute1 = new SumCompute("Thread-1", 3);
        sumCompute1.start();
        int res1 = sumCompute1.getResult();
        SumCompute sumCompute2 = new SumCompute("Thread-2", 4);
        sumCompute2.start();
        int res2 = sumCompute2.getResult();
        
        // Return 0 since threads have not finished
        int final_sum = res1 + res2;
        System.out.println("Final sum: " + final_sum);
    }
}
