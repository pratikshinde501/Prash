
package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Calculator extends JFrame {
    JButton b[];
    JTextField textField;
    String arr[] = {
        "7", "8", "9", "/", 
        "4", "5", "6", "*", 
        "1", "2", "3", "-", 
        "0", "00", "^", "+", 
        "C", "D", "=", "%"
    };

    Calculator() {
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        
        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        setTitle("Calculator");
        setSize(500, 500);
        
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        b = new JButton[20];

        for (int i = 0; i < 20; i++) {
            b[i] = new JButton(arr[i]);
            b[i].setFont(new Font("Arial", Font.BOLD, 38));
            b[i].setFocusable(false);

            String val = arr[i];
            if (val.matches("[0-9]+")) {
                b[i].setBackground(Color.LIGHT_GRAY);
            } else if (val.matches("[+\\-*/%^]")) {
                b[i].setBackground(Color.ORANGE);
            } else if (val.equals("C")) {
                b[i].setBackground(Color.RED);
                b[i].setForeground(Color.WHITE);
            } else if (val.equals("D")) {
                b[i].setBackground(new Color(70, 130, 180));
                b[i].setForeground(Color.WHITE);
            } else if (val.equals("=")) {
                b[i].setBackground(Color.GREEN);
                b[i].setForeground(Color.WHITE);
            }

            panel.add(b[i]);

            b[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = ((JButton) e.getSource()).getText();

                    if (command.equals("=")) {
                            calculateResult1();
                    } else if (command.equals("D")) {
                        String text = textField.getText();
                        if (!text.isEmpty()) {
                            textField.setText(text.substring(0, text.length() - 1));
                        }
                    } else if (command.equals("C")) {
                        textField.setText("");
                    } else {
                        textField.setText(textField.getText() + command);
                    }
                }
            });
        }

        add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JLabel copyright = new JLabel("© 2025 Pratik Shinde", SwingConstants.CENTER);
        copyright.setFont(new Font("Arial", Font.PLAIN, 14));
        add(copyright, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    private void calculateResult1() {

            //final result
    }
    

    public static void main(String[] args) {
        new Calculator();
    }
}
