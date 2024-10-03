import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class First {
    int val;
    void init(int inputVal) { val = inputVal; }
    int square() { return val * val; }
}

class Second extends First {
    int cube() { return square() * val; }
}

public class Main1 {
    Main1() {
        JFrame f = new JFrame("Cube Calculator");
        JTextField inputField = new JTextField();
        JLabel resultLabel = new JLabel("Cube: ");
        JButton calculateButton = new JButton("Calculate Cube");

        calculateButton.addActionListener(e -> {
            try {
                int inputVal = Integer.parseInt(inputField.getText());
                Second s = new Second();
                s.init(inputVal);
                resultLabel.setText("Cube: " + s.cube());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number!");
            }
        });

        f.setLayout(new GridLayout(4, 1));
        f.add(new JLabel("Enter a number:"));
        f.add(inputField);
        f.add(calculateButton);
        f.add(resultLabel);
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Main1();
    }
}
