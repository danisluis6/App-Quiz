package com.example.enclaveit.appquiz.bean;

/**
 * Created by vuongluis on 1/22/17.
 */

public class Exam {
    private String name;
    public Exam(){}
    public Exam(String name){ this.name = name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
