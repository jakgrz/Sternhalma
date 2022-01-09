import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGUI extends JFrame {
    Client client;
    JTextField in;
    JTextArea out;
    JButton postButton;

    public ClientGUI() {
        setSize(320, 240);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));
        setResizable(false);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                client.post("quit");
                System.exit(0);
            }
        });

        String host = JOptionPane.showInputDialog(this, "Enter IP:");

        client = new Client(this, host, 5000);

        in = new JTextField();
        out = new JTextArea();
        out.setEditable(false);
        postButton = new JButton("Post");

        postButton.addActionListener(e -> {
            client.post(in.getText());
            in.setText("");
            in.requestFocus();
//            postButton.setEnabled(false);
        });

        add(out);
        add(postButton);
        add(in);

        setTitle("Sternhalma " + client.getID());
        getRootPane().setDefaultButton(postButton);
    }

    public void receive(String message/*, boolean active*/) {
        out.append(message);
        out.append(System.lineSeparator());
//        if(active) {
//            postButton.setEnabled(true);
//        }
    }

    public static void main(String[] args) {
        ClientGUI client = new ClientGUI();
        client.setVisible(true);
    }
}
