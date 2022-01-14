import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Backend client class.
 * Responsible for handling all behind-the-scenes data transfer.
 */
public class Client {
    int id;
    int count;
    int seed;
    Socket socket;
    ClientGUI gui;
    PrintWriter output;

    public void setID(int id) { this.id = id; }
    public int getID() { return this.id; }

    public void setCount(int count) { this.count = count; }
    public int getCount() { return this.count; }

    public void setSeed(int seed) { this.seed = seed; }
    public int getSeed() { return this.seed; }

    /**
     * A class constructor.
     * @param gui Client GUI associated with this client.
     * @param host IP of host computer.
     */
    public Client(ClientGUI gui, String host) {
        this.gui = gui;
        try {
            socket = new Socket(host, 5000);
            output = new PrintWriter(socket.getOutputStream(), true);
            ClientEcho echo = new ClientEcho(socket, this);
            echo.start();
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host...");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("No I/O...");
            System.exit(1);
        }
    }

    /**
     * Method for sending the data to server.
     * @param message String sent to server.
     */
    public void post(String message) {
        output.println(message);
    }

    /**
     * A method for handling data received from the server.
     * @param message String received from server.
     * @param active Activation flag, used to determine active player.
     */
    public void receive(String message, boolean active) {
        gui.receive(message, active);
    }

    /**
     * Invoking this method closes the client app.
     * @throws IOException Thrown on socket closing error.
     */
    public void quit() throws IOException {
        gui.quit();
        socket.close();
    }
}
