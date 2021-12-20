import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    int id;
    Socket socket;
    ClientGUI gui;
    PrintWriter output;

    public void setID(int id) { this.id = id; }
    public int getID() { return this.id; }

    public Client(ClientGUI gui) {
        this.gui = gui;
        try {
            socket = new Socket("localhost", 5000);
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host...");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("No I/O...");
            System.exit(1);
        }
        new ClientEcho(socket, this).start();
    }

    public void post(String message) {
        output.println(id + ": " + message);
    }

    public void receive(String message) {
        gui.receive(message, (Integer.parseInt(String.valueOf(message.charAt(0))) + 1) % 3 == id);
    }
}
