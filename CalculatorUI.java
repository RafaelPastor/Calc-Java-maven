package org.example;

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
}
