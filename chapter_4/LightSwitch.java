import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LightSwitch {
    private boolean isLightOn = false; 

    LightSwitch() {
        JFrame f = new JFrame("Light Switch");
        JButton switchButton = new JButton("Turn ON");
        JPanel panel = new JPanel();

 
        switchButton.addActionListener(e -> {
            isLightOn = !isLightOn;  
            if (isLightOn) {
                panel.setBackground(Color.YELLOW);  
                switchButton.setText("Turn OFF");
            } else {
                panel.setBackground(Color.GRAY);  
                switchButton.setText("Turn ON");
            }
        });

        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.GRAY);  

        f.add(panel, BorderLayout.CENTER);
        f.add(switchButton, BorderLayout.SOUTH);

        f.setSize(300, 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new LightSwitch();
    }
}
