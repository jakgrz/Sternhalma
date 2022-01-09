import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel;

    MyFrame() {
        this.panel = new MyPanel(new Map(6));
        this.setTitle("Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(720,480);
        //this.setLocationRelativeTo(null);
        this.add(panel);
        //this.pack();
        //this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
}
