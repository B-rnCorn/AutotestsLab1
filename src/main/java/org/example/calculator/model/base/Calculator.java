package org.example.calculator.model.base;

public abstract class Calculator {
    public abstract String add(String a, String b) throws Exception;
    public abstract String subtract(String a, String b) throws Exception;
    public abstract String multiply(String a, String b) throws Exception;
    public abstract String divide(String a, String b) throws Exception;
}
