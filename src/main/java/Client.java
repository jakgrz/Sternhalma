import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    int id;
    Socket socket;
    ClientGUI gui;
    PrintWriter output;

    public void setID(int id) {
        this.id = id;
        gui.setID(id);
    }

    public Client(ClientGUI gui) {
        this.gui = gui;
        listenSocket(5000);
        new ClientEcho(socket, this).start();
    }

    public void listenSocket(int port) {
        try {
            socket = new Socket("localhost", port);
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host...");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("No I/O...");
            System.exit(1);
        }
    }

    public void post(String message) {
        output.println(id + ": " + message + "\n");
    }

    public void receive(String message) {
        gui.receive(message);
    }
}
