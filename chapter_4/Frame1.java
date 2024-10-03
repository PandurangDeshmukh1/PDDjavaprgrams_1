import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame1 extends JFrame {
    private JLabel jlabel1 = new JLabel();
    private JLabel jlabel2 = new JLabel();

    public Frame1() {
        try {
            JbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void JbInit() throws Exception {
        this.getContentPane().setLayout(null);  
        this.setSize(new Dimension(400, 300));

        jlabel1.setText("UserName");
        jlabel1.setBounds(new Rectangle(40, 50, 60, 25)); 

        jlabel2.setText("Password");
        jlabel2.setBounds(new Rectangle(40, 95, 60, 25)); 

        this.getContentPane().add(jlabel1);
        this.getContentPane().add(jlabel2); 
    }

    public static void main(String[] args) {
        Frame1 frame = new Frame1();
        frame.setVisible(true);
    }
}
