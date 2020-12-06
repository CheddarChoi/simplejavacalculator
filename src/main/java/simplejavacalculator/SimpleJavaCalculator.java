/**
 * @name        Simple Java Calculator
 * @file        SimpleJavaCalculator.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

public class SimpleJavaCalculator {
  /**
   * main function for running the calculator.
   * @param args unused
   */
  public static void main(final String[] args) {
    try {
      UI uiCal = new UI();
      uiCal.init();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
