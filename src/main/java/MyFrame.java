import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyPanel panel;
    MyLabel label;

    MyFrame() {
        this.label = new MyLabel();
        this.panel = new MyPanel(new Map(2), 2, label, null);
        this.setTitle("Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel, BorderLayout.CENTER);
        this.add(label,BorderLayout.SOUTH);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
}
