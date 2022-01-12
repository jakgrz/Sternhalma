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
                message = input.readLine();
                if(message.equals("purge")) {
                    client.quit();
                    break;
                }
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < 3; i++) {
                        for(int j = 0; j < 3; j++) {
                            sb.append(message.substring(3 * i + j, 3 * i + j + 1));
                        }
                        sb.append(System.lineSeparator());
                    }
                    client.receive(sb.toString(), Integer.parseInt(message.substring(0, 1)) == client.getID());

            }
        } catch (Exception ex) {
            System.out.println("Error occurred...");
        }
    }
}
