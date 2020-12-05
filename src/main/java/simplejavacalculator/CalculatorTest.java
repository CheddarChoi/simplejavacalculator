package simplejavacalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest extends simplejavacalculator.Calculator {
    private final double delta = 0.0000001;

    @Test
    public void add_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.add, 9999999999.0);
        assertEquals(19999999998.0, (double)calculator.calculateEqual(9999999999.0), delta);
    }

    @Test
    public void add_check_infi() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.divide, 1.0);
        calculator.calculateBi(BiOperatorModes.add, 0.0);
        assertEquals("Infinity", calculator.calculateEqual(1.0).toString());
    }

    @Test
    public void minus_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.minus, 0.1);
        assertEquals(99.856, (double)calculator.calculateEqual(-99.756), delta);
    }

    @Test
    public void minus_check_infi() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.divide, 1.0);
        calculator.calculateBi(BiOperatorModes.minus, 0.0);
        assertEquals("Infinity", calculator.calculateEqual(1.0).toString());
    }

    @Test
    public void multiply_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.multiply, 10000000000.0);
        assertEquals(100000000000000000000.0, (double)calculator.calculateEqual(10000000000.0), delta);
    }

    @Test
    public void multiply_check_infi() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.divide, 1.0);
        calculator.calculateBi(BiOperatorModes.multiply, 0.0);
        assertEquals("NaN", calculator.calculateEqual(0.0).toString());
    }

    @Test
    public void divide_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.divide, 9999999999.0);
        assertEquals(1.0, (double)calculator.calculateEqual(9999999999.0), delta);
    }

    @Test
    public void divide_check_infi() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.divide, 1.0);
        calculator.calculateBi(BiOperatorModes.divide, 0.0);
        assertEquals("Infinity", calculator.calculateEqual(0.0).toString());
    }

    @Test
    public void xpowerofy_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.xpowerofy, 77.7);
        assertEquals(21.0520655280, (double)calculator.calculateEqual(0.7), delta);
    }

    @Test
    public void xpowerofy_check_zero() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        calculator.calculateBi(BiOperatorModes.xpowerofy, 0.0);
        assertEquals(1.0, (double)calculator.calculateEqual(0.0), delta);
    }

    @Test
    public void square_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(111088.89, (double)calculator.calculateMono(MonoOperatorModes.square, 333.3), delta);
    }

    @Test
    public void squareroot_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(1.41421356, (double)calculator.calculateMono(MonoOperatorModes.squareRoot, 2.0), delta);
    }

    @Test
    public void onedividedby_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(0.14285714, (double)calculator.calculateMono(MonoOperatorModes.oneDevidedBy, 7.0), delta);
    }

    @Test
    public void onedividedby_check_zero() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals("Infinity", calculator.calculateMono(MonoOperatorModes.oneDevidedBy, 0.0).toString());
    }

    @Test
    public void cos_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(1.0, (double)calculator.calculateMono(MonoOperatorModes.cos, 0.0), delta);
    }

    @Test
    public void sin_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(0.0, (double)calculator.calculateMono(MonoOperatorModes.sin, 0.0), delta);
    }

    @Test
    public void tan_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(0.0, (double)calculator.calculateMono(MonoOperatorModes.tan, 0.0), delta);
    }

    @Test
    public void log_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(1.0, (double)calculator.calculateMono(MonoOperatorModes.log, 10.0), delta);
    }

    @Test
    public void log_check_zero() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals("-Infinity", calculator.calculateMono(MonoOperatorModes.log, 0.0).toString());
    }

    @Test
    public void rate_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(0.50, (double)calculator.calculateMono(MonoOperatorModes.rate, 50.0), delta);
    }

    @Test
    public void abs_check() {
        simplejavacalculator.Calculator calculator = new simplejavacalculator.Calculator();
        calculator.reset();
        assertEquals(77.77, (double)calculator.calculateMono(MonoOperatorModes.abs, -77.77), delta);
    }
}