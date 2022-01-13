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
            client.setCount(Integer.parseInt(input.readLine()));
            while(true) {
                message = input.readLine();
                if(message.equals("Purge")) {
                    sleep(5000);
                    client.quit();
                    break;
                }
                    client.receive(message, Integer.parseInt(message.substring(0, 1)) == client.getID());
            }
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }
}
