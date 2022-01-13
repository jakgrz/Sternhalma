import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerEcho extends Thread {
    private Socket socket;
    private int id;
    private ArrayList<ServerEcho> echoes;
    private PrintWriter output;
    private int count;

    public ServerEcho(Socket socket, int id, ArrayList<ServerEcho> echoes, int count) {
        this.socket = socket;
        this.id = id;
        this.echoes = echoes;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println(id);
            output.println(count);
            String line;

            while(echoes.size() < count) {
                System.out.println("Waiting " + id);
            }

            if(echoes.indexOf(this) == 0) {
                printToAll(id + "");
            }

            while(true) {
                line = input.readLine();
                if(line.substring(1).isBlank()) {
                    continue;
                }
                if(line.substring(1).equals("quit")) {
                    leave(false);
                    break;
                }
                if(line.substring(1).equals("quitnext")) {
                    printToAll(echoes.get((echoes.indexOf(this)) % echoes.size()).id + "mapHere");
                    leave(false);
                    break;
                }
                if(false /* tutaj sprawdzany jest warunek  */ ) {
                    output.println(id + "mapHere");
                } else {
                    printToAll(echoes.get((echoes.indexOf(this) + 1) % echoes.size()).id + "mapHere");
                }
            }
        } catch (Exception ex) {
            System.out.println(id + " Error occurred...");
            try {
                leave(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void leave(boolean wincheck) throws IOException {
        echoes.remove(this);
        if(echoes.size() < 2 || wincheck) {
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
