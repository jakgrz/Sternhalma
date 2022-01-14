import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGUI extends JFrame {
    Client client;
    MyPanel panel;
    MyLabel label;

    public ClientGUI() throws IOException {
        setSize(720, 720);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(0, 1));
        setResizable(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                quit();
            }
        });

        connect();

        label = new MyLabel();
        panel = new MyPanel(new Map(client.getCount()), client.getCount(), label, client);

        add(panel, BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
    }

    public void connect() throws IOException {
        String host = JOptionPane.showInputDialog(this, "Enter IP:");
        client = new Client(this, host, 5000);
        //out.setText("");
    }

    public void receive(String message, boolean active) {
       panel.setMap(message, active);
    }

    public void quit() {
        /*if(postButton.isEnabled()) {
            client.post("quitnext");
        } else {
            client.post("quit");
        }*/
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        ClientGUI client = new ClientGUI();
        client.setTitle("Sternhalma");
        client.setVisible(true);
    }
}
