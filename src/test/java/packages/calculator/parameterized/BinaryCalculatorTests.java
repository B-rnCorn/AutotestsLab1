package packages.calculator.parameterized;

import org.example.ultimateCalculator.UltimateCalculator;
import org.example.ultimateCalculator.UltimateCalculatorFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinaryCalculatorTests {
    private static final UltimateCalculator calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.BINARY);

    @ParameterizedTest
    @CsvSource({
            "1101,110,10011"
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
            "1101,110,111"
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
            "1101,110,1001110"
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
            "1010,101,10"
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
            "1010,0"
    })
    void testDivideByZero(String a, String b) {
        try {
            assertThrows(ArithmeticException.class,()-> calculator.divide(a, b));
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }
}
