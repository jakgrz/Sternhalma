import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The window app using for controlling the game.
 */
public class ClientGUI extends JFrame {
    Client client;
    MyPanel panel;
    MyLabel label;

    /**
     * A class constructor.
     * @throws IOException Thrown on connection error.
     */
    public ClientGUI() throws IOException {
        setSize(720, 720);
        setLocationRelativeTo(null);
        setResizable(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                quit();
            }
        });

        connect();

        label = new MyLabel();
        panel = new MyPanel(new Map(client.getCount()), client.getCount(), label, client, client.getSeed());

        add(panel, BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
    }

    /**
     * Invoking this method establishes the connection between this client and server.
     * IP is obtained via dialog window.
     * @throws IOException Thrown on connection error.
     */
    public void connect() throws IOException {
        String host = JOptionPane.showInputDialog(this, "Enter IP:");
        client = new Client(this, host);
    }

    /**
     * Method for handling data received from the server.
     * @param message String received from server.
     * @param active Activation flag.
     * @see Client
     */
    public void receive(String message, boolean active) {
       panel.setMap(message, active);
    }

    /**
     * Method for closing the app.
     */
    public void quit() {
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        ClientGUI client = new ClientGUI();
        client.setTitle("Sternhalma");
        client.setVisible(true);
    }
}
