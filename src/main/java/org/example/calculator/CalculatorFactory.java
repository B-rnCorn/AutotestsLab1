package org.example.calculator;

import org.example.calculator.model.BinaryCalculator;
import org.example.calculator.model.HexadecimalCalculator;
import org.example.calculator.model.OctalCalculator;
import org.example.calculator.model.base.Calculator;
import org.example.calculator.model.DecimalCalculator;

public class CalculatorFactory {
    public static CalculatorType getCurrentCalculatorType() {
        return currentCalculatorType;
    }

    public enum CalculatorType {
        DECIMAL,
        BINARY,
        OCTAL,
        HEXADECIMAL,
    }

    private static CalculatorType currentCalculatorType = CalculatorType.DECIMAL;
    public static Calculator getCalculator(CalculatorType calculatorType) {
        switch (calculatorType) {
            case DECIMAL -> {
                currentCalculatorType = CalculatorType.DECIMAL;
                return new DecimalCalculator();
            }
            case BINARY -> {
                currentCalculatorType = CalculatorType.BINARY;
                return new BinaryCalculator();
            }
            case OCTAL -> {
                currentCalculatorType = CalculatorType.OCTAL;
                return new OctalCalculator();
            }
            case HEXADECIMAL -> {
                currentCalculatorType = CalculatorType.HEXADECIMAL;
                return new HexadecimalCalculator();
            }
            default -> throw new IllegalArgumentException("Wrong calculator type:");
        }
    }
}
