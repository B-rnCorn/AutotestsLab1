package org.example.ultimateCalculator;

import java.util.function.BiFunction;

public class UltimateCalculator{
    private final BiFunction<Integer, Integer, String> convertToTarget;
    private final BiFunction<String, Integer, Integer> convertFromString;
    private final Integer radix;

    public UltimateCalculator(BiFunction<Integer, Integer, String> convertToTarget, BiFunction<String, Integer, Integer> convertFromString, Integer radix) {
        this.convertToTarget = convertToTarget;
        this.convertFromString = convertFromString;
        this.radix = radix;
    }


    public String add(String a, String b) throws NumberFormatException {
        return convertToTarget.apply(convertFromString.apply(a,radix) + convertFromString.apply(b,radix), radix);
    }

    public String subtract(String a, String b) throws NumberFormatException {
        return convertToTarget.apply(convertFromString.apply(a,radix) - convertFromString.apply(b,radix), radix);
    }

    public String multiply(String a, String b) throws NumberFormatException {
        return convertToTarget.apply(convertFromString.apply(a,radix) * convertFromString.apply(b,radix), radix);
    }

    public String divide(String a, String b) throws NumberFormatException {
        return convertToTarget.apply(convertFromString.apply(a,radix) / convertFromString.apply(b,radix), radix);
    }
}
