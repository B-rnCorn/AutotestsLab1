package org.example.ultimateCalculator;

public class ConsoleInputController {
    private static UltimateCalculator calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.BINARY);
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
            calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.BINARY);
            return;
        }
        if (a.startsWith("0")) {
            calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.OCTAL);
            return;
        }
        if (a.startsWith("0x") || a.startsWith("0X")) {
            calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.HEXADECIMAL);
            return;
        }
        calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.DECIMAL);
    }

    public static String normalizeInputValue(String input) {
        switch (UltimateCalculatorFactory.getCurrentCalculatorType()) {
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
