package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    private double firstNumber, secondNumber, result;
    private String operator;

    public CalculatorUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        display = new JTextField();
        display.setEditable(false);
        panel.add(display);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberButtonListener());
            panel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        addButton.addActionListener(new OperatorButtonListener());
        panel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(new OperatorButtonListener());
        panel.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new OperatorButtonListener());
        panel.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(new OperatorButtonListener());
        panel.add(divideButton);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(new EqualsButtonListener());
        panel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(new ClearButtonListener());
        panel.add(clearButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = display.getText();
            String buttonText = ((JButton) e.getSource()).getText();
            display.setText(currentText + buttonText);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstNumber = Double.parseDouble(display.getText());
            operator = ((JButton) e.getSource()).getText();
            display.setText("");
        }
    }

    private class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondNumber = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        result = Double.NaN; // Not-a-Number
                    }
                    break;
            }
            display.setText(String.valueOf(result));
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorUI();
            }
        });
    }
}
