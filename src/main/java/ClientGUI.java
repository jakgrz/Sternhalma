import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientGUI extends JFrame {
    int id;
    Client client;
    JTextField in;
    JTextArea out;
    JButton postButton;

    public void setID(int id) { this.id = id; }

    public ClientGUI() {
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        client = new Client(this);

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

        setTitle("Sternhalma " + id);
    }

    public void receive(String message) {
        out.append(message);
//        if(Integer.parseInt(String.valueOf(message.charAt(0))) % 3 == id) {
//            postButton.setEnabled(true);
//        }
    }

    public static void main(String[] args) {
        ClientGUI client = new ClientGUI();
        client.setVisible(true);
    }
}
