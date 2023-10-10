package packages.calculator.dynamic;

import com.opencsv.CSVReader;
import org.example.ultimateCalculator.UltimateCalculator;
import org.example.ultimateCalculator.UltimateCalculatorFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorDynamicTests {

    @TestFactory
    Collection<DynamicTest> testAdd() throws Exception {
        var params = readAllLines(Paths.get(ClassLoader.getSystemResource("binaryData.csv").toURI()));
        return
                params.stream().map((itemParams)-> {
                     UltimateCalculator calculator;

                    switch (itemParams[0]) {
                        case "2" -> calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.BINARY);
                        case "8" -> calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.OCTAL);
                        case "16" -> calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.HEXADECIMAL);
                        default -> calculator = UltimateCalculatorFactory.getCalculator(UltimateCalculatorFactory.CalculatorType.DECIMAL);
                    }

                    return DynamicTest.dynamicTest("Add test", () -> assertEquals(calculator.add(itemParams[1], itemParams[2]), itemParams[3]));
                }).collect(Collectors.toList());
    }

    private List<String[]> readAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }
}
