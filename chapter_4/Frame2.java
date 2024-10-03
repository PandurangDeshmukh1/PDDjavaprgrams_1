import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Frame2 extends JFrame {
    private JLabel jlabel1 = new JLabel();
    private JLabel jlabel2 = new JLabel();
    private JTextArea textArea1 = new JTextArea();
    private JTextArea textArea2 = new JTextArea();

    public Frame2() {
        try {
            JbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void JbInit() throws Exception {
        this.getContentPane().setLayout(null);  
        this.setSize(new Dimension(400, 300));

        jlabel1.setText("Username:");
        jlabel1.setBounds(new Rectangle(40, 50, 80, 25));  

        textArea1.setBounds(new Rectangle(130, 50, 150, 25));  
    
        jlabel2.setText("Password:");
        jlabel2.setBounds(new Rectangle(40, 95, 80, 25));  
        
        textArea2.setBounds(new Rectangle(130, 95, 150, 25));  
        
        this.getContentPane().add(jlabel1);
        this.getContentPane().add(textArea1);
        this.getContentPane().add(jlabel2);
        this.getContentPane().add(textArea2);
    }

    public static void main(String[] args) {
        Frame2 frame = new Frame2();
        frame.setVisible(true);
    }
}
