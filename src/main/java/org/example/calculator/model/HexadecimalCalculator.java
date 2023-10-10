package org.example.calculator.model;

import org.example.calculator.model.base.Calculator;

public class HexadecimalCalculator extends Calculator {
    private int convertToInt(String input) {
        return Integer.valueOf(input, 16);
    }
    @Override
    public String add(String a, String b) throws NumberFormatException {
        return Integer.toHexString(convertToInt(a) + convertToInt(b));
    }

    @Override
    public String subtract(String a, String b) throws NumberFormatException {
        return Integer.toHexString(convertToInt(a) - convertToInt(b));
    }

    @Override
    public String multiply(String a, String b) throws NumberFormatException {
        return Integer.toHexString(convertToInt(a) * convertToInt(b));
    }

    @Override
    public String divide(String a, String b) throws NumberFormatException {
        return Integer.toHexString(convertToInt(a) / convertToInt(b));
    }
}
