import org.junit.Test;
import simplejavacalculator.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
        final UI ui = new UI();
        ui.init();

        Field addButField = ui.getClass().getDeclaredField("butAdd");
        addButField.setAccessible(true);
        Field subButField = ui.getClass().getDeclaredField("butMinus");
        subButField.setAccessible(true);
        Field multiplyButField = ui.getClass().getDeclaredField("butMultiply");
        multiplyButField.setAccessible(true);
        Field divideButField = ui.getClass().getDeclaredField("butDivide");
        divideButField.setAccessible(true);
        Field equalButField = ui.getClass().getDeclaredField("butEqual");
        equalButField.setAccessible(true);
        Field textField = ui.getClass().getDeclaredField("text");
        textField.setAccessible(true);
        JTextArea text = ((JTextArea) textField.get(ui));

        text.setText("100");
        ui.actionPerformed(new ActionEvent(addButField.get(ui), 0, null));
        assertEquals("", text.getText());
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
        final UI ui = new UI();
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
}
