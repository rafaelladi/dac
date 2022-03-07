package com.dietrich.jakarta2;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Named
@RequestScoped
public class HelloBean {
    private Integer input;
    private Integer result;

    public void calculate() {
        this.result = input * input;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}