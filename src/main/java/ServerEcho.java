import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerEcho extends Thread {
    private Socket socket;
    private int id;
    private ArrayList<ServerEcho> echoes;
    private PrintWriter output;

    public ServerEcho(Socket socket, int id, ArrayList<ServerEcho> echoes) {
        this.socket = socket;
        this.id = id;
        this.echoes = echoes;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println(id);
            String line;
            while(true) {
                line = input.readLine();
                if(line == null || line.equalsIgnoreCase("quit")) {
                    break;
                }
                printToAll(line);
            }
            socket.close();
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }

    private void printToAll(String message) {
        for(ServerEcho e : echoes) {
            e.output.println(message);
        }
    }
}
