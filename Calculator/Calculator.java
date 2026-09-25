import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI Calculator application built using Java Swing.
 */
public class Calculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private double num1 = 0;
    private double num2 = 0;
    private char operator = '\0';
    private boolean startNewNumber = true;

    public Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 450);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Layout
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 247));

        // Display Screen
        displayField = new JTextField("0");
        displayField.setFont(new Font("Segoe UI", Font.BOLD, 32));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        displayField.setBackground(Color.WHITE);
        displayField.setForeground(new Color(30, 30, 30));
        displayField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 215), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        displayPanel.setBackground(new Color(245, 245, 247));
        displayPanel.add(displayField, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 8, 8));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        buttonPanel.setBackground(new Color(245, 245, 247));

        // Button definitions: label, background color, text color
        String[] buttons = {
            "C", "DEL", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "±", "0", ".", "="
        };

        for (String text : buttons) {
            JButton button = createStyledButton(text);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.addActionListener(this);

        // Customize button appearance based on button role
        if (text.equals("=")) {
            button.setBackground(new Color(0, 122, 255));
            button.setForeground(Color.WHITE);
        } else if (text.matches("[/\\*\\-\\+]")) {
            button.setBackground(new Color(255, 159, 10));
            button.setForeground(Color.WHITE);
        } else if (text.equals("C") || text.equals("DEL") || text.equals("%")) {
            button.setBackground(new Color(225, 225, 230));
            button.setForeground(Color.BLACK);
        } else {
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
        }

        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Number clicked (0 - 9)
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            if (startNewNumber || displayField.getText().equals("0")) {
                displayField.setText(command);
                startNewNumber = false;
            } else {
                displayField.setText(displayField.getText() + command);
            }
        } 
        // Decimal point
        else if (command.equals(".")) {
            if (startNewNumber) {
                displayField.setText("0.");
                startNewNumber = false;
            } else if (!displayField.getText().contains(".")) {
                displayField.setText(displayField.getText() + ".");
            }
        } 
        // Clear (All Clear)
        else if (command.equals("C")) {
            displayField.setText("0");
            num1 = 0;
            num2 = 0;
            operator = '\0';
            startNewNumber = true;
        } 
        // Delete last digit
        else if (command.equals("DEL")) {
            String text = displayField.getText();
            if (!startNewNumber && text.length() > 0 && !text.equals("Error")) {
                text = text.substring(0, text.length() - 1);
                if (text.isEmpty() || text.equals("-")) {
                    text = "0";
                    startNewNumber = true;
                }
                displayField.setText(text);
            }
        } 
        // Negate (+/-)
        else if (command.equals("±")) {
            try {
                double val = Double.parseDouble(displayField.getText());
                val = -val;
                displayField.setText(formatResult(val));
            } catch (Exception ex) {
                displayField.setText("Error");
            }
        } 
        // Percentage
        else if (command.equals("%")) {
            try {
                double val = Double.parseDouble(displayField.getText()) / 100.0;
                displayField.setText(formatResult(val));
                startNewNumber = true;
            } catch (Exception ex) {
                displayField.setText("Error");
            }
        } 
        // Equals
        else if (command.equals("=")) {
            if (operator != '\0') {
                try {
                    num2 = Double.parseDouble(displayField.getText());
                    double result = calculate(num1, num2, operator);
                    if (Double.isNaN(result) || Double.isInfinite(result)) {
                        displayField.setText("Error");
                    } else {
                        displayField.setText(formatResult(result));
                    }
                } catch (Exception ex) {
                    displayField.setText("Error");
                }
                operator = '\0';
                startNewNumber = true;
            }
        } 
        // Operators (+, -, *, /)
        else {
            try {
                if (operator != '\0' && !startNewNumber) {
                    num2 = Double.parseDouble(displayField.getText());
                    double result = calculate(num1, num2, operator);
                    if (Double.isNaN(result) || Double.isInfinite(result)) {
                        displayField.setText("Error");
                        operator = '\0';
                        startNewNumber = true;
                        return;
                    }
                    displayField.setText(formatResult(result));
                    num1 = result;
                } else {
                    num1 = Double.parseDouble(displayField.getText());
                }
                operator = command.charAt(0);
                startNewNumber = true;
            } catch (Exception ex) {
                displayField.setText("Error");
            }
        }
    }

    private double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) return Double.NaN;
                return a / b;
            default: return b;
        }
    }

    private String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.valueOf(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }
            new Calculator().setVisible(true);
        });
    }
}
