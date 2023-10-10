package org.example.ultimateCalculator.functions;

import java.util.function.BiFunction;

public class ConvertFromString implements BiFunction<String, Integer, Integer> {

    @Override
    public Integer apply(String string, Integer radix) {
        return Integer.parseInt(string, radix);
    }
}
