package com.example.restservice;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;

public class RForAPI {
    
    public String mean() throws REngineException, REXPMismatchException {
        RConnection c = new RConnection();
        // double d = c.eval("print(paste(\'Hello from R:\', mean(c(1,2,3))));").asDouble();
        String d = c.eval("res <- mean(c(1,2,3));print(paste('Hello from R:',res));").asString();
        // With error library('hello');
        // String d = c.eval("res <- mean(c(1,2,3));library('hello');print(paste('Hello from R:',res));").asString();
        
        System.out.println(d);
        return d;
    }

    // public String givenRScript_whenRProcessInvoked_thenSuccess() throws Exception {
    //     ProcessBuilder processBuilder = new ProcessBuilder("R", resolvePythonScriptPath("hello.R"));
    //     processBuilder.redirectErrorStream(true);

    //     Process process = processBuilder.start();
    //     List<String> results = readProcessOutput(process.getInputStream());

    //     System.out.println(results);

    //     return results.toString();
    // }

    // public double mean(int[] values) throws REngineException, REXPMismatchException {
    //     RConnection c = new RConnection();
    //     c.assign("input", values);
    //     System.out.println(c.eval("customMean(input)").asDouble());
    //     return c.eval("customMean(input)").asDouble();
    // }
}
