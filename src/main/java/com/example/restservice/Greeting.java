package com.example.restservice;

public class Greeting {

    private final long id;
    private final String content;

    // ctor
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // getter
    public long getId() {
        return id;
    }

    // getter
    public String getContent() {
        return content;
    }
}