import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    int id;
    int count;
    Socket socket;
    ClientGUI gui;
    PrintWriter output;

    public void setID(int id) { this.id = id; }
    public int getID() { return this.id; }

    public void setCount(int count) { this.count = count; }
    public int getCount() { return this.count; }

    public Client(ClientGUI gui, String host, int port) throws IOException {
        this.gui = gui;
        try {
            socket = new Socket(host, port);
            output = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host...");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("No I/O...");
            System.exit(1);
        }
        ClientEcho echo = new ClientEcho(socket, this);
        echo.start();
    }

    public void post(String message) {
        output.println(message);
    }

    public void receive(String message, boolean active) {
        gui.receive(message, active);
    }

    public void quit() throws IOException {
        gui.quit();
        socket.close();
    }
}
