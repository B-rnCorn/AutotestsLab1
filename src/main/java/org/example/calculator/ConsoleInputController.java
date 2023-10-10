package org.example.calculator;

import org.example.calculator.model.base.Calculator;

public class ConsoleInputController {
    private static Calculator calculator = CalculatorFactory.getCalculator(CalculatorFactory.CalculatorType.BINARY);
    public static String applyOperation(String a, String b, String operationInput) {
        detectCalculatorType(a);
        switch (operationInput) {
            case "/" -> {
                try {
                    return calculator.divide(normalizeInputValue(a),normalizeInputValue(b));
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
            case "*" -> {
                try {
                    return calculator.multiply(normalizeInputValue(a),normalizeInputValue(b));
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
            case "+" -> {
                try {
                    return calculator.add(normalizeInputValue(a),normalizeInputValue(b));
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
            case "-" -> {
                try {
                    return calculator.subtract(normalizeInputValue(a),normalizeInputValue(b));
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
            default -> {
                return "Такая операция не поддерживается";
            }
        }
    }

    public static void detectCalculatorType(String a) {
        if (a.startsWith("0b") || a.startsWith("0B")) {
            calculator = CalculatorFactory.getCalculator(CalculatorFactory.CalculatorType.BINARY);
            return;
        }
        if (a.startsWith("0")) {
            calculator = CalculatorFactory.getCalculator(CalculatorFactory.CalculatorType.OCTAL);
            return;
        }
        if (a.startsWith("0x") || a.startsWith("0X")) {
            calculator = CalculatorFactory.getCalculator(CalculatorFactory.CalculatorType.HEXADECIMAL);
            return;
        }
        calculator = CalculatorFactory.getCalculator(CalculatorFactory.CalculatorType.DECIMAL);
    }

    public static String normalizeInputValue(String input) {
        switch (CalculatorFactory.getCurrentCalculatorType()) {
            case BINARY, HEXADECIMAL -> {
                return input.substring(2);
            }
            case OCTAL -> {
                return input.substring(1);
            }
            default -> {
                return input;
            }
        }
    }
}
