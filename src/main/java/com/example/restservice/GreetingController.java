package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws Exception {
        PythonForAPI pythonForAPI = new PythonForAPI();
        String out = pythonForAPI.givenPythonScript_whenPythonProcessInvoked_thenSuccess();

        RForAPI rForAPI = new RForAPI();
        String mean = rForAPI.mean();

        // int[] values = new int[]{
        //     1,2,3
        // };

        // return new Greeting(counter.incrementAndGet(), String.format(template, "hello"));
        // return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return new Greeting(counter.incrementAndGet(), String.format(template, out));
        // return new Greeting(counter.incrementAndGet(), String.format(template, mean));
    }

    @GetMapping("/greeting/version")
    public String getVersionInfo(){
        return "Version - V1";
    }
}