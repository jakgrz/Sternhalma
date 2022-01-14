import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * A server thread used to handle individual client connections.
 */
public class ServerEcho extends Thread {
    private Socket socket;
    private int id;
    private ArrayList<ServerEcho> echoes;
    private PrintWriter output;
    private int count;
    private int seed;

    /**
     * A class constructor.
     * @param socket Socket with accepted client connection.
     * @param id Unique ID given by server.
     * @param echoes List of all server threads.
     * @param count Number of expected connections.
     * @see Server
     */
    public ServerEcho(Socket socket, int id, ArrayList<ServerEcho> echoes, int count, int seed) {
        this.socket = socket;
        this.id = id;
        this.echoes = echoes;
        this.count = count;
        this.seed = seed;
    }

    /**
     * A thread's run method.
     */
    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println(id);
            output.println(count);
            output.println(seed);
            String line;

            while(echoes.size() < count) {
                System.out.println("Waiting " + id);
            }

            while(true) {
                line = input.readLine();
                if(line.substring(1).isBlank()) {
                    System.out.println("Blank");
                } else if(line.substring(1).equals("quit")) {
                    leave();
                    break;
                } else {
                    printToAll(line);
                }
            }
        } catch (Exception ex) {
            System.out.println(id + " Error occurred...");
            try {
                leave();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void leave() throws IOException {
        echoes.remove(this);
        if(echoes.size() < 2) {
            printToAll("Purge");
            output.println("Purge");
        }
        socket.close();
    }

    private void printToAll(String message) {
        for(ServerEcho e : echoes) {
            e.output.println(message);
        }
    }
}
