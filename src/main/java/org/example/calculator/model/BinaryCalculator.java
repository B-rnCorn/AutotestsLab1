package org.example.calculator.model;

import org.example.calculator.model.base.Calculator;

public class BinaryCalculator extends Calculator {
    private int convertToInt(String input) {
        return Integer.valueOf(input, 2);
    }
    @Override
    public String add(String a, String b) throws NumberFormatException {
        return Integer.toBinaryString(convertToInt(a) + convertToInt(b));
    }

    @Override
    public String subtract(String a, String b) throws NumberFormatException {
        return Integer.toBinaryString(convertToInt(a) - convertToInt(b));
    }

    @Override
    public String multiply(String a, String b) throws NumberFormatException {
        return Integer.toBinaryString(convertToInt(a) * convertToInt(b));
    }

    @Override
    public String divide(String a, String b) throws NumberFormatException {
        return Integer.toBinaryString(convertToInt(a) / convertToInt(b));
    }
}
