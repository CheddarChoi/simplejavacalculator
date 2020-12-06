/**
 * @name        Simple Java Calculator
 * @file        Calculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import static java.lang.Double.NaN;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public class NotReachException extends RuntimeException {
        /**
         * Exception handling fot the case when no operator matches.
         * @param msg message to print
         */
        public NotReachException(final String msg) {
            super(msg);
        }
    }

    public enum BiOperatorModes {
        /**
         * Possible operator modes for two numbers.
         */
        normal, add, minus, multiply, divide, xpowerofy
    }

    public enum MonoOperatorModes {
        /**
         * Possible operator modes for a single number.
         */
        square, squareRoot, oneDevidedBy, cos, sin, tan, log, rate, abs
    }

    /**
     * Variable where the first number is stored.
     */
    private Double num1;
    /**
     * Variable where the second number is stored.
     */
    private Double num2;
    /**
     * The first operator is the normal mode.
     */
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1, num2);
        }

        // never reach
        throw new NotReachException("never reach");
    }

    /**
     * Performs an operation on a new number with the last calculated number.
     * @param newMode operator used in operation
     * @param num number used in operation
     * @return calculated operation
     */
    public Double calculateBi(final BiOperatorModes newMode, final Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    /**
     * @param num final number obtained after calculation
     * @return final number
     */
    public Double calculateEqual(final Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    /**
     * Resets the calculator values.
     * @return NaN
     */
    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }

    /**
     * Performs an operation on a single number.
     * @param newMode operator used in operation
     * @param num number used in operation
     * @return calculated operation
     */
    public Double calculateMono(final MonoOperatorModes newMode,
                                final Double num) {
        final int pi = 180;
        final int percent = 100;
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDevidedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(num);
        }
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(num);
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % pi == 0) {
                return 0.0;
            }
            if (num % (pi / 2) == 0 && num % pi != 0) {
                return NaN;
            }

            return Math.tan(num);
        }
        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / percent;
        }
        if (newMode == MonoOperatorModes.abs) {
            return Math.abs(num);
        }

        // never reach
        throw new NotReachException("never reach");
    }

}
