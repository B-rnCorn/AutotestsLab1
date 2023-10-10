package packages;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import packages.calculator.parameterized.BinaryCalculatorTests;
import packages.calculator.parameterized.DecimalCalculatorTests;
import packages.calculator.parameterized.HexadecimalCalculatorTests;
import packages.calculator.parameterized.OctalCalculatorTests;

import java.io.PrintWriter;

public class TestLauncher {
    public static void main(String[] args) {
        var launcher = LauncherFactory.create();
        var summaryGeneratingListener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request().selectors(
                DiscoverySelectors.selectClass(BinaryCalculatorTests.class),
                DiscoverySelectors.selectClass(DecimalCalculatorTests.class),
                DiscoverySelectors.selectClass(OctalCalculatorTests.class),
                DiscoverySelectors.selectClass(HexadecimalCalculatorTests.class)
        ).build();
        launcher.execute(request, summaryGeneratingListener);

        try (var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(new PrintWriter(writer));
        }
    }
}
