/**
 * @name        Simple Java Calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;


import java.io.IOException;

public class UI implements ActionListener {

   /**
    * Main frame for the calculator.
    */
   private final JFrame frame;

   /**
    * Parent panel.
    */
   private final JPanel panel;

   /**
    * Panel for displaying the number.
    */
   private final JPanel panelSub1;

   /**
    * Panel for buttons 1, 2, 3, +, -.
    */
   private final JPanel panelSub2;

   /**
    * Panel for buttons 4, 5, 6, *, /.
    */
   private final JPanel panelSub3;

   /**
    * Panel for buttons 7, 8, 9, equals, clear.
    */
   private final JPanel panelSub4;

   /**
    * Panel for button 0.
    */
   private final JPanel panelSub5;

   /**
    * Panel for buttons square, square root, inverse, and x power to y.
    */
   private final JPanel panelSub6;

   /**
    * Panel for buttons cos, sin, tan.
    */
   private final JPanel panelSub7;

   /**
    * Panel for buttons log, modulo, absolute value, binary.
    */
   private final JPanel panelSub8;

   /**
    * Text area for displaying the number.
    */
   private final JTextArea text;

   /**
    * Number buttons for the calculator.
    */
   private final JButton[] but;

   /**
    * Other buttons for the calculator.
    */
   private final JButton butAdd, butMinus, butMultiply, butDivide,
      butEqual, butCancel, butSquareRoot, butSquare, butOneDevidedBy,
      butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary;

   /**
    * Calculator.
    */
   private final Calculator calc;

   /**
    * Number button values.
    */
   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};

   /**
    * Font for the buttons.
    */
   private final Font font;
   /**
    * Font for the number display.
    */
   private final Font textFont;

   /**
    * Assemble the calculator frame.
    * @throws IOException
    */
   public UI() throws IOException {
      frame = new JFrame("Calculator PH");

      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());

      final int fontSize = 18;
      font = new Font("Consolas", Font.PLAIN, fontSize);

      final int textSize = 30;
      text = new JTextArea(1, textSize);

      final int textFontSize = 24;
      textFont = new Font("Consolas", Font.BOLD, textFontSize);

      final int digits = 10;
      but = new JButton[digits];
      for (int i = 0; i < digits; i++) {
         but[i] = new JButton(String.valueOf(i));
      }
      butAdd = new JButton("+");
      butMinus = new JButton("-");
      butMultiply = new JButton("*");
      butDivide = new JButton("/");
      butEqual = new JButton("=");
      butSquareRoot = new JButton("sqrt");
      butSquare = new JButton("x*x");
      butOneDevidedBy = new JButton("1/x");
      butCos = new JButton("Cos");
      butSin = new JButton("Sin");
      butTan = new JButton("Tan");
      butxpowerofy = new JButton("x^y");
      butlog = new JButton("log10(x)");
      butrate = new JButton("x%");
      butabs = new JButton("abs(x)");
      butCancel = new JButton("C");
      butBinary = new JButton("Bin");

      calc = new Calculator();

   }

   /**
    * Create and fill the frame for the calculator.
    */
   public void init() {
      final int size = 450;
      frame.setSize(size, size);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      text.setFont(textFont);
      text.setEditable(false);

      final int buttonNumber = 10;
      for (int i = 0; i < buttonNumber; i++) {
         but[i].setFont(font);
      }
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDevidedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font);

      final int horStruct = 100;
      panel.add(Box.createHorizontalStrut(horStruct));
      panelSub1.add(text);
      panel.add(panelSub1);

      final int one = 1;
      final int two = 2;
      final int three = 3;
      final int four = 4;
      final int five = 5;
      final int six = 6;
      final int seven = 7;
      final int eight = 8;
      final int nine = 9;
      final int zero = 0;

      final int horSpace = 15;
      panelSub2.add(but[one]);
      panelSub2.add(but[two]);
      panelSub2.add(but[three]);
      panelSub2.add(Box.createHorizontalStrut(horSpace));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);

      panelSub3.add(but[four]);
      panelSub3.add(but[five]);
      panelSub3.add(but[six]);
      panelSub3.add(Box.createHorizontalStrut(horSpace));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);
      panel.add(panelSub3);

      panelSub4.add(but[seven]);
      panelSub4.add(but[eight]);
      panelSub4.add(but[nine]);
      panelSub4.add(Box.createHorizontalStrut(horSpace));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);

      final int horSpace2 = 210;
      panelSub5.add(but[zero]);
      panelSub5.add(Box.createHorizontalStrut(horSpace2));
      panel.add(panelSub5);

      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDevidedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);

      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);

      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);

      for (int i = 0; i < buttonNumber; i++) {
         but[i].addActionListener(this);
      }

      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDevidedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);

      butEqual.addActionListener(this);
      butCancel.addActionListener(this);

      frame.add(panel);
   }

   /**
    * Handles the action performed bu the user.
    * @param e Information about the action performed by the user.
    */
   @Override
   public void actionPerformed(final ActionEvent e) {
      final Object source = e.getSource();

      final int buttonNum = 10;
      for (int i = 0; i < buttonNum; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }

      if (source == butAdd) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
      }

      if (source == butMinus) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
      }

      if (source == butMultiply) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.multiply,
                                 reader()));
      }

      if (source == butDivide) {
         writer(calc.calculateBi(
                 Calculator.BiOperatorModes.divide, reader()));
      }
      if (source == butxpowerofy) {
         writer(calc.calculateBi(
                 Calculator.BiOperatorModes.xpowerofy, reader()));
      }

      if (source == butSquare) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.square,
                                   reader()));
      }

      if (source == butSquareRoot) {
         writer(calc.calculateMono(
                 Calculator.MonoOperatorModes.squareRoot, reader()));
      }

      if (source == butOneDevidedBy) {
         writer(calc.calculateMono(
                 Calculator.MonoOperatorModes.oneDevidedBy, reader()));
      }

      if (source == butCos) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.cos,
                                   reader()));
      }

      if (source == butSin) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.sin,
                                   reader()));
      }

      if (source == butTan) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.tan,
                                   reader()));
      }
      if (source == butlog) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.log,
                                   reader()));
      }
      if (source == butrate) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.rate,
                                   reader()));
      }
      if (source == butabs) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));
      }

      if (source == butEqual) {
         writer(calc.calculateEqual(reader()));
      }

      if (source == butCancel) {
         writer(calc.reset());
      }

      if (source == butBinary) {
         parsetoBinary();
      }

      text.selectAll();
   }

   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }

   /**
    * Converts the text on the calculator screen to a double.
    * @return the number displayed on the calculator.
    */
   public Double reader() {
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);

      return num;
   }

   /**
    * Writesa new number to the calculator string.
    * @param num Number to be displayed.
    */
   public void writer(final Double num) {
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
