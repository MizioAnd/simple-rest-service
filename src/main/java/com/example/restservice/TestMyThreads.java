package com.example.restservice;

public class TestMyThreads {
    public static void main(String args[]) {
        String[] threadNames = {"thread-1", "thread-2"};

        int ite = 3;
        for (String element: threadNames){
            SumCompute sumCompute = new SumCompute(element, ite);
            sumCompute.start();
            ite++;
        }

//        SumCompute sumCompute1 = new SumCompute("Thread-1", 3);
//        sumCompute1.start();
//        int res1 = sumCompute1.getResult();
//        SumCompute sumCompute2 = new SumCompute("Thread-2", 4);
//        sumCompute2.start();
//        int res2 = sumCompute2.getResult();

        // Return 0 since threads have not finished
//        int final_sum = res1 + res2;
//        System.out.println("Final sum: " + final_sum);

        // Implement report job thread

    }
}
