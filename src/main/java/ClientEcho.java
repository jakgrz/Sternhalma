import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientEcho extends Thread {
    private Socket socket;
    private Client client;

    public ClientEcho(Socket socket, Client client) {
        this.socket = socket;
        this.client = client;
    }

    @Override
    public void run() {
        String message;
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            client.setID(Integer.parseInt(input.readLine()));
            while(true) {
                client.receive(input.readLine());
            }
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }
}
