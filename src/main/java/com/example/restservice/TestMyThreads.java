package com.example.restservice;

import com.sun.source.tree.TryTree;

public class TestMyThreads {
    public static void main(String args[]) {

        // Create report job
        ReportJob reportJob = new ReportJob();
        reportJob.start();
    }
}
