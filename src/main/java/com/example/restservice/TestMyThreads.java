package com.example.restservice;

import com.sun.source.tree.TryTree;

public class TestMyThreads {
    public static void main(String args[]) {
        String[] threadNames = {"thread-1", "thread-2", "thread-report"};
        SumCompute sc = new SumCompute();
        int ite = 3;
        int idxThread = 0;
        ThreadCompute[] threads = new ThreadCompute[3];
        for (String element: threadNames){
            ThreadCompute threadCompute = new ThreadCompute(element, ite, sc);
            threads[idxThread] = threadCompute;
            threadCompute.start();
//            threadCompute.join();
//            if (ite == 4){
//                threadCompute.join();
//            }
            idxThread++;
            ite++;
        }
        for (ThreadCompute element: threads){
            element.join();
        }
//
//        try{
//        } catch (Exception e) {
//            System.out.println("Interrupted");
//        }

//        ThreadCompute threadCompute1 = new ThreadCompute("Thread-1", 3);
//        threadCompute1.start();
//        int res1 = threadCompute1.getResult();
//        ThreadCompute threadCompute2 = new ThreadCompute("Thread-2", 4);
//        threadCompute2.start();
//        int res2 = threadCompute2.getResult();

        // Return 0 since threads have not finished
//        int final_sum = res1 + res2;
//        System.out.println("Final sum: " + final_sum);

        // Implement report job thread

    }
}
