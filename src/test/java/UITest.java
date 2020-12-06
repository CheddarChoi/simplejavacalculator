import org.junit.Test;
import simplejavacalculator.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class UITest {

    @Test
    public void num_but_test() throws IOException, NoSuchFieldException, IllegalAccessException {
        UI ui = new UI();
        ui.init();

        Field butField = ui.getClass().getDeclaredField("but");
        butField.setAccessible(true);
        Object but = butField.get(ui);

        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("");
        ui.actionPerformed(new ActionEvent(Array.get(but, 0), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 1), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 2), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 3), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 4), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 5), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 6), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 7), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 8), 0, null));
        ui.actionPerformed(new ActionEvent(Array.get(but, 9), 0, null));
        assertEquals("9876543210", text.getText());
    }

    @Test
    public void num_but_with_position_select_test() throws IOException, NoSuchFieldException, IllegalAccessException {
        UI ui = new UI();
        ui.init();

        Field butField = ui.getClass().getDeclaredField("but");
        butField.setAccessible(true);
        Object but = butField.get(ui);

        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("");
        text.select(0, 0);
        ui.actionPerformed(new ActionEvent(Array.get(but, 0), 0, null));
        text.select(1, 1);
        ui.actionPerformed(new ActionEvent(Array.get(but, 1), 0, null));
        text.select(2, 2);
        ui.actionPerformed(new ActionEvent(Array.get(but, 2), 0, null));
        text.select(3, 3);
        ui.actionPerformed(new ActionEvent(Array.get(but, 3), 0, null));
        text.select(4, 4);
        ui.actionPerformed(new ActionEvent(Array.get(but, 4), 0, null));
        text.select(5, 5);
        ui.actionPerformed(new ActionEvent(Array.get(but, 5), 0, null));
        text.select(6, 6);
        ui.actionPerformed(new ActionEvent(Array.get(but, 6), 0, null));
        text.select(7, 7);
        ui.actionPerformed(new ActionEvent(Array.get(but, 7), 0, null));
        text.select(8, 8);
        ui.actionPerformed(new ActionEvent(Array.get(but, 8), 0, null));
        text.select(9, 9);
        ui.actionPerformed(new ActionEvent(Array.get(but, 9), 0, null));
        assertEquals("0123456789", text.getText());
    }

    @Test
    public void text_replace_test() throws IOException, NoSuchFieldException, IllegalAccessException {
        UI ui = new UI();
        ui.init();

        Field butField = ui.getClass().getDeclaredField("but");
        butField.setAccessible(true);
        Object but = butField.get(ui);

        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("0123");
        text.select(1, 3);
        ui.actionPerformed(new ActionEvent(Array.get(but, 4), 0, null));
        assertEquals("043", text.getText());
    }

    @Test
    public void op_but_test() throws IOException, NoSuchFieldException, IllegalAccessException {
        UI ui = new UI();
        ui.init();

        Field addButField = ui.getClass().getDeclaredField("butAdd");
        addButField.setAccessible(true);
        Field subButField = ui.getClass().getDeclaredField("butMinus");
        subButField.setAccessible(true);
        Field multiplyButField = ui.getClass().getDeclaredField("butMultiply");
        multiplyButField.setAccessible(true);
        Field divideButField = ui.getClass().getDeclaredField("butDivide");
        divideButField.setAccessible(true);
        Field powerButField = ui.getClass().getDeclaredField("butxpowerofy");
        powerButField.setAccessible(true);
        Field equalButField = ui.getClass().getDeclaredField("butEqual");
        equalButField.setAccessible(true);
        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("10");
        ui.actionPerformed(new ActionEvent(powerButField.get(ui), 0, null));
        assertEquals("", text.getText());
        text.setText("2");
        ui.actionPerformed(new ActionEvent(addButField.get(ui), 0, null));
        assertEquals("100.0", text.getText());
        text.setText("10");
        ui.actionPerformed(new ActionEvent(subButField.get(ui), 0, null));
        assertEquals("110.0", text.getText());
        text.setText("9");
        ui.actionPerformed(new ActionEvent(multiplyButField.get(ui), 0, null));
        assertEquals("101.0", text.getText());
        text.setText("2");
        ui.actionPerformed(new ActionEvent(divideButField.get(ui), 0, null));
        assertEquals("202.0", text.getText());
        text.setText("5");
        ui.actionPerformed(new ActionEvent(equalButField.get(ui), 0, null));
        assertEquals("40.4", text.getText());
    }

    @Test
    public void cancel_but_test() throws IOException, NoSuchFieldException, IllegalAccessException {
        UI ui = new UI();
        ui.init();

        Field addButField = ui.getClass().getDeclaredField("butAdd");
        addButField.setAccessible(true);
        Field cancelButField = ui.getClass().getDeclaredField("butCancel");
        cancelButField.setAccessible(true);
        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("11");
        ui.actionPerformed(new ActionEvent(cancelButField.get(ui), 0, null));
        assertEquals("", text.getText());

        text.setText("21");
        ui.actionPerformed(new ActionEvent(addButField.get(ui), 0, null));
        text.setText("22");
        ui.actionPerformed(new ActionEvent(cancelButField.get(ui), 0, null));
        assertEquals("", text.getText());

        text.setText("31");
        ui.actionPerformed(new ActionEvent(addButField.get(ui), 0, null));
        text.setText("32");
        ui.actionPerformed(new ActionEvent(addButField.get(ui), 0, null));
        ui.actionPerformed(new ActionEvent(cancelButField.get(ui), 0, null));
        assertEquals("", text.getText());
    }

    @Test
    public void testBtnMonoOp() throws IOException, NoSuchFieldException, IllegalAccessException {
        UI ui = new UI();
        ui.init();

        Field squareRootButField = ui.getClass().getDeclaredField("butSquareRoot");
        squareRootButField.setAccessible(true);
        Field squareButField = ui.getClass().getDeclaredField("butSquare");
        squareButField.setAccessible(true);
        Field oneDevidedByButField = ui.getClass().getDeclaredField("butOneDevidedBy");
        oneDevidedByButField.setAccessible(true);
        Field cosButField = ui.getClass().getDeclaredField("butCos");
        cosButField.setAccessible(true);
        Field sinButField = ui.getClass().getDeclaredField("butSin");
        sinButField.setAccessible(true);
        Field tanButField = ui.getClass().getDeclaredField("butTan");
        tanButField.setAccessible(true);
        Field logButField = ui.getClass().getDeclaredField("butlog");
        logButField.setAccessible(true);
        Field rateButField = ui.getClass().getDeclaredField("butrate");
        rateButField.setAccessible(true);
        Field absButField = ui.getClass().getDeclaredField("butabs");
        absButField.setAccessible(true);
        Field binaryButField = ui.getClass().getDeclaredField("butBinary");
        binaryButField.setAccessible(true);
        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("36");
        ui.actionPerformed(new ActionEvent(squareRootButField.get(ui), 0, null));
        assertEquals("6.0", text.getText());
        text.setText("7");
        ui.actionPerformed(new ActionEvent(squareButField.get(ui), 0, null));
        assertEquals("49.0", text.getText());
        text.setText("-8");
        ui.actionPerformed(new ActionEvent(squareButField.get(ui), 0, null));
        assertEquals("64.0", text.getText());
        text.setText("0.1");
        ui.actionPerformed(new ActionEvent(oneDevidedByButField.get(ui), 0, null));
        assertEquals("10.0", text.getText());
        text.setText("Infinity");
        ui.actionPerformed(new ActionEvent(oneDevidedByButField.get(ui), 0, null));
        assertEquals("0.0", text.getText());
        ui.actionPerformed(new ActionEvent(oneDevidedByButField.get(ui), 0, null));
        assertEquals("Infinity", text.getText());
        text.setText(Double.toString(0));
        ui.actionPerformed(new ActionEvent(cosButField.get(ui), 0, null));
        assertEquals("1.0", text.getText());
        text.setText(Double.toString(0));
        ui.actionPerformed(new ActionEvent(sinButField.get(ui), 0, null));
        assertEquals("0.0", text.getText());
        text.setText(Double.toString(0));
        ui.actionPerformed(new ActionEvent(tanButField.get(ui), 0, null));
        assertEquals("0.0", text.getText());
        text.setText(Double.toString(10));
        ui.actionPerformed(new ActionEvent(logButField.get(ui), 0, null));
        assertEquals("1.0", text.getText());
        text.setText(Double.toString(-11));
        ui.actionPerformed(new ActionEvent(absButField.get(ui), 0, null));
        assertEquals("11.0", text.getText());
        text.setText(Double.toString(99));
        ui.actionPerformed(new ActionEvent(rateButField.get(ui), 0, null));
        assertEquals("0.99", text.getText());
        text.setText("2");
        ui.actionPerformed(new ActionEvent(binaryButField.get(ui), 0, null));
        assertEquals("10", text.getText());

        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        text.setText(Double.toString(2));
        ui.actionPerformed(new ActionEvent(binaryButField.get(ui), 0, null));
        assertEquals("Error while parse to binary.java.lang.NumberFormatException: For input string: \"2.0\""+System.getProperty("line.separator"), errContent.toString());
    }
}
