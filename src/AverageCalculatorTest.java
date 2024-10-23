import org.junit.Test;
import static org.junit.Assert.*;

public class AverageCalculatorTest {

    private AverageCalculator calculator = new AverageCalculator();

    // Basis Path 1 Tests
    @Test
    public void testImmediateTermination() {
        int[] values = {-999};
        assertEquals("Immediate termination with -999",

                -999, calculator.average(values, 0, 100));
    }

    @Test
    public void testEmptyArray() {
        int[] values = new int[0];
        assertEquals("Empty array handling",
                -999, calculator.average(values, 0, 100));
    }

    // Basis Path 2 Tests
    @Test
    public void testSingleInvalidAboveRange() {
        int[] values = {150, -999};
        assertEquals("Single invalid value above range",
                -999, calculator.average(values, 0, 100));
    }

    @Test
    public void testSingleInvalidBelowRange() {
        int[] values = {-50, -999};
        assertEquals("Single invalid value below range",
                -999, calculator.average(values, 0, 100));
    }

    // Basis Path 3 Tests
    @Test
    public void testSingleValidValue() {
        int[] values = {50, -999};
        assertEquals("Single valid value",
                50, calculator.average(values, 0, 100));
    }

    @Test
    public void testMinimumBoundaryValue() {
        int[] values = {0, -999};
        assertEquals("Minimum boundary value",
                0, calculator.average(values, 0, 100));
    }

    @Test
    public void testMaximumBoundaryValue() {
        int[] values = {100, -999};
        assertEquals("Maximum boundary value",
                100, calculator.average(values, 0, 100));
    }

    // Basis Path 4 Tests
    @Test
    public void testMixedValidInvalidValues() {
        int[] values = {50, 150, 75, -999};
        assertEquals("Mixed valid and invalid values",
                62, calculator.average(values, 0, 100));
    }

    @Test
    public void testMixedValuesWithBoundaries() {
        int[] values = {-50, 50, 150, 100, -999};
        assertEquals("Mixed values with boundaries",
                75, calculator.average(values, 0, 100));
    }

    @Test
    public void testMultipleValidWithOneInvalid() {
        int[] values = {50, 60, 70, 80, 90, 110, -999};
        assertEquals("Multiple valid values with one invalid",
                70, calculator.average(values, 0, 100));
    }

    // Additional Edge Case Tests
    @Test
    public void testInputNumberLimit() {
        // Create array with 101 values (exceeding 100 limit)
        int[] values = new int[101];
        for(int i = 0; i < values.length; i++) {
            values[i] = 50;
        }
        assertEquals("Input number limit",
                50, calculator.average(values, 0, 100));
    }
}