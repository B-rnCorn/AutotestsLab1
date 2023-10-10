package org.example.ultimateCalculator;

import org.example.ultimateCalculator.functions.ConvertFromString;
import org.example.ultimateCalculator.functions.ConvertToTargetRadix;

public class UltimateCalculatorFactory {
    public static CalculatorType getCurrentCalculatorType() {
        return currentCalculatorType;
    }

    public enum CalculatorType {
        DECIMAL,
        BINARY,
        OCTAL,
        HEXADECIMAL,
    }

    private static CalculatorType currentCalculatorType = CalculatorType.BINARY;
    public static UltimateCalculator getCalculator(CalculatorType calculatorType) {
        switch (calculatorType) {
            case BINARY -> {
                currentCalculatorType = CalculatorType.BINARY;
                return new UltimateCalculator(new ConvertToTargetRadix(), new ConvertFromString(), 2);
            }
            case OCTAL -> {
                currentCalculatorType = CalculatorType.OCTAL;
                return new UltimateCalculator(new ConvertToTargetRadix(), new ConvertFromString(), 8);
            }
            case DECIMAL -> {
                currentCalculatorType = CalculatorType.DECIMAL;
                return new UltimateCalculator(new ConvertToTargetRadix(), new ConvertFromString(), 10);
            }
            case HEXADECIMAL-> {
                currentCalculatorType = CalculatorType.HEXADECIMAL;
                return new UltimateCalculator(new ConvertToTargetRadix(), new ConvertFromString(), 16);
            }
            default -> throw new IllegalArgumentException("Wrong calculator type:");
        }
    }
}
