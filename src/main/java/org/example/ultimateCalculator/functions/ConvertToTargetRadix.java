package org.example.ultimateCalculator.functions;

import java.util.function.BiFunction;

public class ConvertToTargetRadix implements BiFunction<Integer, Integer, String> {

    @Override
    public String apply(Integer value, Integer radix) {
        switch (radix) {
            case 2 -> {return Integer.toBinaryString(value);}
            case 8 -> {return Integer.toOctalString(value);}
            case 10 -> {return Integer.toString(value);}
            case 16 -> {return Integer.toHexString(value);}
        }

        return Integer.toBinaryString(value);
    }
}
