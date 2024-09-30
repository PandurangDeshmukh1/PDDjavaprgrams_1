import java.awt.*;
import java.awt.event.*;

public class SimpleAWTform {
    public static void main(String[] args) {
        Frame frame = new Frame("User Information Form");
        Label nameLabel = new Label("Name:");
        Label emailLabel = new Label("Email:");

        TextField nameField = new TextField(20);
        TextField emailField = new TextField(20);

        Button submitButton = new Button("Submit");

        nameLabel.setBounds(30, 50, 100, 20);
        nameField.setBounds(150, 50, 150, 20);
        emailLabel.setBounds(30, 100, 100, 20);
        emailField.setBounds(150, 100, 150, 20);
        submitButton.setBounds(30, 150, 100, 30);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(submitButton);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String message = "Name: " + name + "\nEmail: " + email;

                // Show message dialog
                Dialog dialog = new Dialog(frame, "User Information", true);
                dialog.setSize(300, 150);
                dialog.setLayout(new FlowLayout());
                Label messageLabel = new Label(message);
                Button okButton = new Button("OK");

                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                dialog.add(messageLabel);
                dialog.add(okButton);
                dialog.setVisible(true);
            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
