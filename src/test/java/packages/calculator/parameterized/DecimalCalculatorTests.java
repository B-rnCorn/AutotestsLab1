package packages.calculator.parameterized;

import org.example.ultimateCalculator.UltimateCalculator;
import org.example.ultimateCalculator.UltimateCalculatorFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DecimalCalculatorTests {
    private static final UltimateCalculator calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.DECIMAL);

    @ParameterizedTest
    @CsvSource({
            "10,10,20"
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
            "10,10,0"
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
            "6,5,30"
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
            "15,5,3"
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
            "15,0"
    })
    void testDivideByZero(String a, String b) {
        try {
            assertThrows(ArithmeticException.class,()-> calculator.divide(a, b));
        } catch (Exception e) {
            fail("Некорректные данные");
        }
    }
}
