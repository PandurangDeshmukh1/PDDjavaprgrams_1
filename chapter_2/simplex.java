import java.awt.EventQueue;
import javax.swing.JFrame;

public class simplex extends JFrame {
    public simplex() {
        initUI();
    }

    private void initUI() {
        setTitle("Simple Example");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            simplex ex = new simplex(); 
            ex.setVisible(true);
        });
    }
}

