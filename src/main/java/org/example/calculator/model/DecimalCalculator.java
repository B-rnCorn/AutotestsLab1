package org.example.calculator.model;

import org.example.calculator.model.base.Calculator;

import static java.lang.Integer.parseInt;

public class DecimalCalculator extends Calculator {
    @Override
    public String add(String a, String b) throws NumberFormatException {
        return Integer.toString(parseInt(a) + parseInt(b));
    }

    @Override
    public String subtract(String a, String b) throws NumberFormatException {
        return Integer.toString(parseInt(a) - parseInt(b));
    }

    @Override
    public String multiply(String a, String b) throws NumberFormatException {
        return Integer.toString(parseInt(a) * parseInt(b));
    }

    @Override
    public String divide(String a, String b) throws NumberFormatException {
        return Integer.toString(parseInt(a) / parseInt(b));
    }
}
