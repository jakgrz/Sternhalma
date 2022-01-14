import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientEcho extends Thread {
    private Socket socket;
    private Client client;
    BufferedReader input;

    public ClientEcho(Socket socket, Client client) throws IOException {
        this.socket = socket;
        this.client = client;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        client.setID(Integer.parseInt(input.readLine()));
        client.setCount(Integer.parseInt(input.readLine()));
        client.setSeed(Integer.parseInt(input.readLine()));
    }

    @Override
    public void run() {
        String message;
        try {
            while(true) {
                message = input.readLine();
                if(message.equals("Purge")) {
                    sleep(5000);
                    client.quit();
                    break;
                }
                client.receive(message, Character.getNumericValue(message.charAt(0)) == client.getID());
            }
        } catch (Exception ex) {
            System.out.println("Error occurred...\n");
            ex.printStackTrace();
        }
    }
}
