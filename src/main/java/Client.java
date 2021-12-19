import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame {
    char id;
    Socket socket = null;
    JTextField in;
    JTextArea out;
    JButton postButton;
    BufferedReader input = null;
    PrintWriter output = null;
    boolean flag = false;

    public Client(char id) {
        this.id = id;
        setTitle("Sternhalma" + id);
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        in = new JTextField();
        out = new JTextArea();
        out.setEditable(false);
        postButton = new JButton("Post");

        postButton.addActionListener(e -> {
            if(!flag) {
                output.println(id + " " + in.getText());
                in.setText("");
                in.requestFocus();
                try {
                    listen();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        add(out);
        add(postButton);
        add(in);
    }

    public void listenSocket(int port) {
        try {
            socket = new Socket("localhost", port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host...");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("No I/O...");
            System.exit(1);
        }
    }

    public void listen() throws IOException {
        String message;
        flag = true;
        while(flag) {
            message = input.readLine();
            out.setText(message);
            if(message.charAt(0) == '2') {
                flag = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client('0');
        client.setVisible(true);
        client.listenSocket(5000);
    }
}
