package org.example.calculator.model;

import org.example.calculator.model.base.Calculator;

public class OctalCalculator extends Calculator {
    private int convertToInt(String input) {
        return Integer.valueOf(input, 8);
    }
    @Override
    public String add(String a, String b) throws NumberFormatException {
        return Integer.toOctalString(convertToInt(a) + convertToInt(b));
    }

    @Override
    public String subtract(String a, String b) throws NumberFormatException {
        return Integer.toOctalString(convertToInt(a) - convertToInt(b));
    }

    @Override
    public String multiply(String a, String b) throws NumberFormatException {
        return Integer.toOctalString(convertToInt(a) * convertToInt(b));
    }

    @Override
    public String divide(String a, String b) throws NumberFormatException {
        return Integer.toOctalString(convertToInt(a) / convertToInt(b));
    }
}
