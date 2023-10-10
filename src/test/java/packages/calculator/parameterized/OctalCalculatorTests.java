package packages.calculator.parameterized;

import org.example.ultimateCalculator.UltimateCalculator;
import org.example.ultimateCalculator.UltimateCalculatorFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class OctalCalculatorTests {
    private static final UltimateCalculator calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.OCTAL);

    @ParameterizedTest
    @CsvSource({
            "12,12,24"
    })
    void testAdd(String a, String b, String result) {
        try {
            assertEquals(calculator.add(a, b), result);
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "12,12,0"
    })
    void testSubtract(String a, String b, String result) {
        try {
            assertEquals(calculator.subtract(a, b), result);
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "6,5,36"
    })
    void testMultiply(String a, String b, String result) {
        try {
            assertEquals(calculator.multiply(a, b), result);
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "17,5,3"
    })
    void testDivide(String a, String b, String result) {
        try {
            assertEquals(calculator.divide(a, b), result);
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "17,0"
    })
    void testDivideByZero(String a, String b) {
        try {
            assertThrows(ArithmeticException.class,()-> calculator.divide(a, b));
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }
}
